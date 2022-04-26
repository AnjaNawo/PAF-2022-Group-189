package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/electrog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertCustomer(String FirstName, String LastName, String CustomerAddress, String Gender, String CustomerMobileNo) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into customer(`CustomerID`,`FirstName`,`LastName`,`CustomerAddress`,`Gender`,`CustomerMobileNo`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, FirstName);
			preparedStmt.setString(3, LastName);
			preparedStmt.setString(4, CustomerAddress);
			preparedStmt.setString(5, Gender);
			preparedStmt.setString(6, CustomerMobileNo);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the customer.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readCustomer() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Customer ID</th><th>First Name</th><th>Last Name</th><th>Address</th><th>Gender</th><th>Mobile No</th></tr>";
			String query = "select * from customer";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String CustomerID = Integer.toString(rs.getInt("CustomerID"));
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String CustomerAddress = rs.getString("CustomerAddress");
				String Gender = rs.getString("Gender");
				String CustomerMobileNo = rs.getString("CustomerMobileNo");

				// Add into the html table
				output += "<tr><td>" + CustomerID + "</td>";
				output += "<td>" + FirstName + "</td>";
				output += "<td>" + LastName + "</td>";
				output += "<td>" + CustomerAddress + "</td>";
				output += "<td>" + Gender + "</td>";
				output += "<td>" + CustomerMobileNo + "</td>";			
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the customer.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateCustomer(String CustomerID, String FirstName, String LastName, String CustomerAddress, String Gender, String CustomerMobileNo) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE customer SET FirstName=?,LastName=?,CustomerAddress=?,Gender=?,CustomerMobileNo=?" + "WHERE CustomerID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, FirstName);
			preparedStmt.setString(2, LastName);
			preparedStmt.setString(3, CustomerAddress);
			preparedStmt.setString(4, Gender);
			preparedStmt.setString(5, CustomerMobileNo);
			preparedStmt.setInt(6, Integer.parseInt(CustomerID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the customer.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteCustomer(String CustomerID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from customer where CustomerID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(CustomerID));
			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the customer.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
