package in.co.sunrays.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * TCP Client exchanges Hello with Client.
 * 
 * @version 1.0
 * @since 01 Feb 2015
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class HelloTCPClient {

	public static void main(String[] args) throws Exception {
		// Create Socket object using constructor accepting Server's IP and Port
		// number
		Socket client = new Socket("localhost", 1234);
		// Open Client’s Input Stream
		DataInputStream in = new DataInputStream(client.getInputStream());
		// Open Client’s Output Stream
		DataOutputStream out = new DataOutputStream(client.getOutputStream());

		// Write greetings to Server
		out.writeBytes("Hello Server\n");

		// Read greeting sent by Server
		String greeting = in.readLine();

		System.out.println(greeting);

		// Close connection with server
		client.close();
	}
}
