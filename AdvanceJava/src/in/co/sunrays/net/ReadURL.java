package in.co.sunrays.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Reads Text from a URL .
 * 
 * You need Internet connection to see the output of this program.
 * 
 * @version 1.0
 * @since 01 Feb 2015
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class ReadURL {

	public static void main(String[] args) throws IOException {

		InputStream inStream = null;

		URL u = null;
		try {
			u = new URL("http://www.yahoo.com");
			inStream = u.openStream();

		} catch (Exception e) {
			System.out.println("Error in URL");
			System.exit(0); // Terminate execution.
		}

		Scanner in = new Scanner(inStream);

		while (in.hasNext()) {
			String str = in.nextLine().replace("Yahoo", "Sunrays");

			System.out.println(str);
		}

		in.close();

	}

}
