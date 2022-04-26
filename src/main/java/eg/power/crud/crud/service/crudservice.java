package eg.power.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eg.power.crud.crud.model.crudmodel;

public class crudservice {
	
	Connection con;
	
	public crudservice() {
	
	try {
		String url = String.format ("jdbc:mysql://localhost:3306/powercut scheduling");
		String uname = "root";
		String pwd = vdgdgdg;	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uname,pwd);
		
	} catch(Exception e) {
		System.out.println(e + "data insert unsucess.");
	}
  }

		
	public crudmodel addPowercut(crudmodel powercut) {
		String insert = "insert into powercut schedule details(lineNo,areaNo,areaName,startTime,endTime,date,reason) values(?,?,?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, powercut.getLineNo() );
			ps.setString(2, powercut.getAreaNo());
			ps.setString(3, powercut.getAreaName());
			ps.setString(4, powercut.getStartTime());
			ps.setString(5, powercut.getEndTime());
			ps.setString(6, powercut.getDate());
			ps.setString(7, powercut.getReason());
			
			ps.execute();
	}catch(Exception e) {
			System.out.println(e + "data insert unsucess.");
		}
		
		return powercut;
	}
	
	public ArrayList<crudmodel> getPowercut() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from powercut schedule details ";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setLineNo(rs.getString("lineNo"));
			model.setAreaNo(rs.getString("areaNo"));
			model.setAreaName(rs.getString("areaName"));
			model.setStartTime(rs.getString("startTime"));
			model.setEndTime(rs.getString("endTime"));
			model.setDate(rs.getString("date"));
			model.setReason(rs.getString("reason"));
			
			data.add(model);
		}
		
		return data;
	}
	
public ArrayList<crudmodel> getPowercutById(int id) throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from powercut schedule details where id =? ";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setLineNo(rs.getString("lineNo"));
			model.setAreaNo(rs.getString("areaNo"));
			model.setAreaName(rs.getString("areaName"));
			model.setStartTime(rs.getString("startTime"));
			model.setEndTime(rs.getString("endTime"));
			model.setDate(rs.getString("date"));
			model.setReason(rs.getString("reason"));	
			data.add(model);
		}
		
		return data;
	}

	public crudmodel updatePowercut(crudmodel powercut) {
	String insert = "update powercut schedule details set lineNo=?,areaNo,areaName,startTime,endTime,date,reason) values(?,?,?,?,?,?,?) ";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1, powercut.getId());
		ps.setString(2, powercut.getLineNo() );
		ps.setString(3, powercut.getAreaNo());
		ps.setString(4, powercut.getAreaName());
		ps.setString(5, powercut.getStartTime());
		ps.setString(6, powercut.getEndTime());
		ps.setString(7, powercut.getDate());
		ps.setString(8, powercut.getReason());
		
		ps.executeUpdate();
			}catch(Exception e) {
		System.out.println(e + "data insert unsucess.");
	}
	
	return powercut;
}
	
	public int deletePowercut(int id) {
		String insert = "delete from powercut schedule details where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,id);
			
			ps.execute();
				}catch(Exception e) {
			System.out.println(e + "data deletion unsucess.");
		}
		
		return id;
	}


}
