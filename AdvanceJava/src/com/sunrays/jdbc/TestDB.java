package com.sunrays.jdbc;

import java.sql.*;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 */

public class TestDB {

	public static void main(String args[]) throws Exception {
		testSelect();
		//testInsert();
	}

	public static void testSelect() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "root", "root");
		
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt
				.executeQuery("SELECT id, name, color from part");

		System.out.println("ID\tName\tColor");
		System.out.println("--\t----\t-----");

		while (rs.next()) {

			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getString("color"));
		}

		stmt.close();
		conn.close();

	}

	public static void testInsert() throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/test", "root", "root");

		conn.setAutoCommit(false);

		Statement stmt = conn.createStatement();

		int i = stmt
				.executeUpdate("INSERT into part values (5,'plat1','Green',1)");

		System.out.print(i + " Record(s) Updated");

		conn.commit();
		stmt.close();
		conn.close();
	}

	public static void testPreparedInsert() throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/test", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn
				.prepareStatement("INSERT into part values (?,?,?,?)");

		ps.setInt(1, 7);
		ps.setString(2, "Plat2");
		ps.setString(3, "Red");
		ps.setInt(4, 1);
		int recCount = ps.executeUpdate();

		System.out.println("# of Records" + recCount);

		System.out.print(recCount + " Record(s) Updated");

		conn.commit();
		ps.close();
		conn.close();
	}

}