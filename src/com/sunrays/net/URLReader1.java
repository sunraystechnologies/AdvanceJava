package com.sunrays.net;

import java.net.*;
import java.util.Scanner;
import java.io.*;

/*
 * copyright (c) sunRays Technologies Indore 
 * @author: sunRays Developer 
 * @url : www.sunrays.co.in
 * 
 */

public class URLReader1 {
	public static void main(String[] args) throws Exception {

		URL yahoo = new URL("http://www.yahoo.com/");

		URLConnection yahooConnection = yahoo.openConnection();
		
		yahooConnection.connect();

		InputStream inStream = yahooConnection.getInputStream(); 

		Scanner in = new Scanner(inStream);

		while (in.hasNext()) {
			System.out.println(in.nextLine());
		}
		
		inStream.close();

	}
}
