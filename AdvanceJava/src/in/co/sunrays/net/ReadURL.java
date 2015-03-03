package in.co.sunrays.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ReadURL {

	/*
	 * copyright (c) sunRays Technologies Indore 
	 * @author: sunRays Developer 
	 * @url: www.sunrays.co.in
	 * 
	 */

	public static void main(String[] args) throws IOException {

		InputStream inStream = null;

		URL u = null;
		try {
			u = new URL("http://www.yahoo.com");
			inStream = u.openStream();

		} catch (Exception e) {
			System.out.println("Error in URL");
			System.exit(0);
		}

		Scanner in = new Scanner(inStream);

		while (in.hasNext()) {
			String str = in.nextLine().replace("Yahoo", "Sunrays");

			System.out.println(str);
		}

		in.close();

	}

}
