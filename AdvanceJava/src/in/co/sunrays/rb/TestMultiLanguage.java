package in.co.sunrays.rb;

import java.util.Locale;
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

public class TestMultiLanguage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		//Default Locale
		ResourceBundle rb = ResourceBundle.getBundle("in.co.sunrays.rb.app");

		System.out.println(rb.getString("greeting"));

		//Create a Locale for Spanish and set to RB
		rb = ResourceBundle.getBundle("in.co.sunrays.rb.app", new Locale("sp"));

		System.out.println(rb.getString("greeting"));

		//Create a Locale for Hindi and set to RB
		rb = ResourceBundle.getBundle("in.co.sunrays.rb.app", new Locale("hi"));
		System.out.println(rb.getString("greeting"));

		rb = ResourceBundle.getBundle("in.co.sunrays.rb.app", new Locale("hi","IN"));
		System.out.println(rb.getString("greeting"));


		rb = ResourceBundle.getBundle("in.co.sunrays.rb.app", new Locale("hi","IN","UP"));
		System.out.println(rb.getString("greeting"));


	}

}
