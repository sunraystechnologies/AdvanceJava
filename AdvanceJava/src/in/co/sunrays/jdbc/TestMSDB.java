package in.co.sunrays.jdbc;

import java.sql.*;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 */


/**
 * Tests MS Access Database connectivity.
 * 
 * @version 1.0
 * @since 01 Feb 2015
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class TestMSDB {

	public static void main(String args[]) throws Exception {
		// testUpdate();
		testSelect();
	}

	public static void testSelect() throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		Connection conn = DriverManager.getConnection("jdbc:odbc:BATCH06", "",
				"");

		Statement stmt = conn.createStatement();

		ResultSet rs = null;

		rs = stmt.executeQuery("SELECT id,firstName,lastname from employee");

		System.out.println("ID\tName\t\tLast Color");
		System.out.println("--\t----\t\t-----");

		while (rs.next()) {

			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString("firstName"));
			System.out.println("\t\t" + rs.getString(3));
		}

		stmt.close();
		conn.close();

	}

	public static void testUpdate() throws Exception {
		// Class.forName("com.mysql.jdbc.Driver").newInstance();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		// Connection conn =
		// DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=root");

		Connection conn = DriverManager.getConnection("jdbc:odbc:BATCH06", "",
				"");

		/*
		 * Statement stmt = conn.createStatement(); int recCount =
		 * stmt.executeUpdate("insert into employee values(3,'Nikku','Verma')");
		 */

		PreparedStatement ps = conn
				.prepareStatement("insert into employee values(?,?,?)");

		ps.setInt(1, 6);
		ps.setString(2, "Chandra");
		ps.setString(3, "Joshi");
		int recCount = ps.executeUpdate();

		System.out.println("# of Records" + recCount);

		// stmt.close();
		ps.close();
		conn.close();

	}

}