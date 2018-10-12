package com.db.junit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.db.junit.Customer;

public class CustomerTest {

	private static Connection ct;
	private static Customer cobj;
	
	@BeforeClass
	public static void createConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		ct=	DriverManager.getConnection("jdbc:mysql://localhost/testdbb", "user", "password");
		cobj = new Customer(ct);
		
		System.out.println("Connection 1");
	}
	
	
	@Test
	public void testGetCustomer() throws SQLException {
			List<String> lstc = cobj.getCustomers();
		
		//String strrs[]=(String [])lstc.toArray();
		String strrs[]=lstc.toArray(new String[0]);
		//strrs[0]=lstc.get(0);
		Assert.assertArrayEquals(strrs, new String[] {"abcd","pqrs","lmno"});
		
		
		System.out.println(lstc);
	}
	@Test
	public void testgetCustomers() throws SQLException
	{
		List<String> lstc = cobj.getCustomers();
		String[] v3 = lstc.toArray(new String[lstc.size()]);
		Assert.assertArrayEquals(v3, new String[] {"param","vir","yolo"});
		System.out.println(lstc);
	}
	@Test
	public void testInsertCustomer() throws SQLException
	{
		String sarr[] = {"name1","name2","name3","name4"};
		//List<String> lstc = cobj.getCustomers();
		
		List <String> lst = new ArrayList<String>(Arrays.asList(sarr));
		
		int arows= cobj.insertCustomers(lst);
		
		Assert.assertEquals(arows,lst.size());
		
		System.out.println(arows);
		
	}
	
}


/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.db.junit.Customer;
import com.mysql.jdbc.Driver;

public class CustomerTest {
	
	private static Customer cobj;
	
	@BeforeClass  //Always use static method because it gets executed before the creation of an object
	public static  void createConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection ct = DriverManager.getConnection("jdbc:mysql://localhost/testdbb","user","password");
		cobj = new Customer(ct);
	}
	
	@Test
	public void testgetCustomers() throws SQLException
	{
		List<String> lstc = cobj.getCustomers();
		String[] v3 = lstc.toArray(new String[lstc.size()]);
		Assert.assertArrayEquals(v3, new String[] {"param","vir","yolo"});
		System.out.println(lstc);
	}

}
*/