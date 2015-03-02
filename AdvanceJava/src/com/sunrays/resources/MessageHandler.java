package com.sunrays.resources;

import java.util.ResourceBundle;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 */

public class MessageHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.resources.messages");
		
		String value = rb.getString("database.target");

		System.out.println(value);

	}

}
