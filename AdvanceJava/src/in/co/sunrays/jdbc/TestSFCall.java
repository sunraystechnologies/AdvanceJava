package in.co.sunrays.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/**
 * Calls a Stored Function call.
 * 
 * @version 1.0
 * @since 01 Feb 2015
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class TestSFCall {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/st_test", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{? = CALL FuncTest()}");
		callStmt.registerOutParameter(1, Types.VARCHAR);
		callStmt.execute();

		System.out.println(" Count " + callStmt.getString(1));
	}

}
