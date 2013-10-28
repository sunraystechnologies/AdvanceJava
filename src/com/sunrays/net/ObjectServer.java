package com.sunrays.net;

import java.io.*;
import java.net.*;

import com.sunrays.dto.Employee;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 * 
 */

public class ObjectServer {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = null;

		serverSocket = new ServerSocket(4444);

		System.out.println("Object Server Started");

		Socket clientSocket = null;

		boolean flag = true;

		while (flag) {

			clientSocket = serverSocket.accept();

			talk(clientSocket);
		}
		System.out.println("Echo Server Stoped");
		serverSocket.close();
	}

	public static void talk(Socket clientSocket) throws Exception {

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		ObjectInputStream in = new ObjectInputStream(clientSocket
				.getInputStream());

		Employee emp = (Employee) in.readObject();

		System.out.println("ID : " + emp.getId());
		System.out.println("First Name : " + emp.getFirstName());
		System.out.println("Last Name : " + emp.getLastName());
		System.out.println("Temp Value: " + emp.getTempValue());

		out.println("Got the Object");
		out.close();
		in.close();
		clientSocket.close();

	}

}