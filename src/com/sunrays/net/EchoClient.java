package com.sunrays.net;

import java.io.*;
import java.net.*;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 * 
 */

public class EchoClient {
	public static void main(String[] args) throws IOException {

		Socket echoSocket = new Socket("127.0.0.1", 4444);

		PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket
				.getInputStream()));

		System.out.println("Echo Client Started");
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));

		String userInput;
		userInput = stdIn.readLine();

		while (userInput != null) {
			out.println(userInput);
			System.out.println("echo: " + in.readLine());
			if ("Bye.".equals(userInput)) {
				break;
			}
			userInput = stdIn.readLine();
		}

		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}