package in.co.sunrays.net;

import java.io.*;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 * 
 */

public class MultiThreadQuoteServer {
	public static void main(String[] args) throws IOException {
		new QuoteServerThread().start();
	}
}
