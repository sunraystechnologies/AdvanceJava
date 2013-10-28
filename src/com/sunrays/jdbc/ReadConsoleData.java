package com.sunrays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 */

public class ReadConsoleData {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement ps = conn
				.prepareStatement("INSERT into part values (?,?,?,?)");

		java.util.Scanner sc = new Scanner(System.in);

		String data = null;

		boolean flag = true;

		while (true) {
			
			System.out.print("Enter ID ");
			
			data = sc.nextLine();

			if (data.equals("00")) {
				System.out.println("Bye Bye");
				break;
			}
					
			ps.setInt(1, Integer.parseInt(data));
			
			System.out.print("Enter Name ");
			
			data = sc.nextLine();

			ps.setString(2, data);

			System.out.print("Enter Color ");
						
			data = sc.nextLine();

			ps.setString(3,data);

			System.out.print("Enter Unit ID ");
			
			data = sc.nextLine();

			ps.setInt(4, Integer.parseInt(data));

			ps.executeUpdate();

			System.out.println("Record is insrted");
		}

		ps.close();
		conn.close();

	}
}