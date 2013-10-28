package com.sunrays.net;

import java.net.*;
import java.io.*;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 */

public class URLWriteReader1 {
	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:8080/aajkiapp/HelloName.jsp");

	
		URLConnection connection = url.openConnection();

		connection.setDoOutput(true);

		OutputStreamWriter out = new OutputStreamWriter(connection
				.getOutputStream());

		out.write("fn=Akash");
		out.write("&ln=Mehta");
		//out.write("&hl=en&btnG=Google+Search&meta=");

		out.close();

		connection.connect();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection
				.getInputStream()));

		String decodedString;

		while ((decodedString = in.readLine()) != null) {
			System.out.println(decodedString);
		}
		in.close();

	}
}
