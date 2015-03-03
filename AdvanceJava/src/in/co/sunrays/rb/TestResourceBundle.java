package in.co.sunrays.rb;

import java.util.ResourceBundle;

/**
 * Test ResourceBundle that reads a value from .properties file using Key.
 * 
 * @version 1.0
 * @since 01 Feb 2015
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class TestResourceBundle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.sunrays.rb.app");

		String value = rb.getString("organization.name");

		System.out.println(value);

	}

}
