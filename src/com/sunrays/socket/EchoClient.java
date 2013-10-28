package com.sunrays.socket;

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

		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		// try {
		echoSocket = new Socket("127.0.0.1", 4444);
		out = new PrintWriter(echoSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(echoSocket
				.getInputStream()));
		/*
		 * } catch (UnknownHostException e) { System.err.println("Don't know
		 * about host: taranis."); System.exit(1); } catch (IOException e) {
		 * System.err.println("Couldn't get I/O for " + "the connection to:
		 * taranis."); System.exit(1); }
		 */

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