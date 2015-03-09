package in.co.sunrays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Insert a record into a Table with transaction handling.
 * 
 * @version 1.0
 * @since 01 Feb 2015
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class InsertRecordWithTx {

	public static void main(String args[]) throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/test", "root", "");

		conn.setAutoCommit(false); // Start Transaction

		Statement stmt = conn.createStatement();

		int i = stmt
				.executeUpdate("INSERT into part values (5,'Plat','Green',1)");

		System.out.print(i + " Record(s) Updated");

		conn.commit(); // End Transaction

		stmt.close();
		conn.close();

	}

	/**
	 * Executes INSERT statement with help of Prepared Statement.
	 * 
	 * @throws Exception
	 */

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