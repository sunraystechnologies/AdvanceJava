package com.sunrays.net;

import java.net.*;
import java.io.*;

/*
 * copyright (c) sunRays Technologies Indore 
 * @author: sunRays Developer 
 * @url : www.sunrays.co.in
 * 
 */

public class URLWriter {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://www.google.co.in/search");

		URLConnection connection = url.openConnection();

		connection.setDoOutput(true);

		OutputStreamWriter out = new OutputStreamWriter(connection
				.getOutputStream());

		out.write("q=books");
		// out.write("&hl=en&btnG=Google+Search&meta=");

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
