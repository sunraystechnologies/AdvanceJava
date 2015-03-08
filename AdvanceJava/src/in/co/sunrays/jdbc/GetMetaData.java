package in.co.sunrays.jdbc;

import java.sql.*;

/**
 * Gets Meta Data of SQL Statement and print
 * 
 * @version 1.0
 * @since 01 Feb 2015
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class GetMetaData {

	public static void main(String args[]) throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/ST_TEST", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = rs = stmt
				.executeQuery("SELECT id, name, color from ST_PART");

		ResultSetMetaData rsmt = rs.getMetaData();

		System.out.println("Catelog Name : " + rsmt.getCatalogName(1));
		System.out.println("Table Name : " + rsmt.getTableName(1));

		int columnCount = rsmt.getColumnCount();
		System.out.println("Total Columns :" + columnCount);
		System.out.println();

		for (int i = 1; i <= columnCount; i++) {
			System.out.println("Column :" + (i));
			System.out.println("Label : " + rsmt.getColumnLabel(i));
			System.out.println("Name : " + rsmt.getColumnName(i));
			System.out.println("Type : " + rsmt.getColumnTypeName(i));
			System.out.println("Size : " + rsmt.getColumnDisplaySize(i));
			System.out.println("Precision : " + rsmt.getPrecision(i));
			System.out.println();
		}

		stmt.close();
		conn.close();

	}

}