package com.db.junit;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Customer {
	//retrieve list of Customer
	
	private Connection ct;
	
	public Customer(Connection ct) {
	
		this.ct=ct;
	}
	public List<String> getCustomers() throws SQLException{
		
		java.sql.PreparedStatement ps = ct.prepareStatement("SELECT * FROM customer ");
		ResultSet rs = ps.executeQuery();
		
		List<String> ls= new ArrayList<String>() ;
		
		while(rs.next()) {
			ls.add(rs.getString("cname"));
		}
		
		return ls;
	}
	public int insertCustomers(List<String> customers) throws SQLException {
		
		PreparedStatement ps= ct.prepareStatement("INSERT INTO customer (cname) values(?)");
		int  affectedRows = 0;
		for(String name:customers)
		{
			ps.setString(1, name);
			
			if(ps.executeUpdate() == 0) {
				affectedRows++;
				
			}
		}
		
		return affectedRows;
		
	}
	
}
