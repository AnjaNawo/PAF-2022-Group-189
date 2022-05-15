package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class payment {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			/* Provide the correct details: DBServer/DBName, username, password */
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/payments?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertPayments(String amount, String cardName, String cardNumber, String CVV, String cardType) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into payments(`paymentID`,`amount`,`cardName`,`cardNumber`,`CVV`,`cardType`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, amount);
			preparedStmt.setString(3, cardName);
			preparedStmt.setString(4, cardNumber);
			preparedStmt.setString(5, CVV);
			preparedStmt.setString(6, cardType);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readPayment() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>payment ID</th><th>amount </th><th>card name</th><th>card Number</th><th>CVV</th><th>card Type</th></tr>";
			String query = "select * from payments";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String paymentID = Integer.toString(rs.getInt("paymentID"));
				String amount = rs.getString("amount");
				String cardName = rs.getString("cardName");
				String cardNumber = rs.getString("cardNumber");
				String CVV = rs.getString("CVV");
				String cardType = rs.getString("cardType");

				// Add into the html table
				output += "<tr><td>" + paymentID + "</td>";
				output += "<td>" + amount + "</td>";
				output += "<td>" + cardName + "</td>";
				output += "<td>" + cardNumber + "</td>";
				output += "<td>" + CVV + "</td>";
				output += "<td>" + cardType + "</td>";			
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatePayment(String paymentID, String amount, String cardName, String cardNumber, String CVV, String cardType) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE payments SET amount=?,cardName=?,cardNumber=?,CVV=?,cardType=?" + "WHERE paymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, amount);
			preparedStmt.setString(2, cardName);
			preparedStmt.setString(3, cardNumber);
			preparedStmt.setString(4, CVV);
			preparedStmt.setString(5, cardType);
			preparedStmt.setInt(6, Integer.parseInt(paymentID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String deletePayment(String paymentID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from payments where paymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(paymentID));
			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
