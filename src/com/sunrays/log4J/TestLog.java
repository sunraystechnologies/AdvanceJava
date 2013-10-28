package com.sunrays.log4J;

import org.apache.log4j.Logger;

/*
 * copyright (c) sunRays Technologies Indore
 * @author: sunRays Developer
 * @url : www.sunrays.co.in
 *
 */

public class TestLog {

	static Logger logger = Logger.getLogger(TestLog.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		logger.debug("This is Debug Statment");
		logger.info("This is Info Statment");
		logger.warn("This is Warn Statment");
		logger.error("This is Error Statment");
		logger.fatal("This is Fatal Statment");

		int i = 0;

		try {
			int x = 5 / i;
		} catch (RuntimeException e) {
			logger.error("Aritmetic Erro ",e);
		}

	}

}
