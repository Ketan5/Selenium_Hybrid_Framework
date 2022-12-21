package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import TestBase.BaseTestClass;

public class Log{

	private final static Logger log = LogManager.getLogger(Log.class);

	public static void startTestCase(String testCaseName) {
		log.info("=====================================" + testCaseName
				+ " TEST START=========================================");
	}

	public static void endTestCase(String testCaseName) {
		log.info("=====================================" + testCaseName
				+ " TEST END=========================================");
	}

	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void error(String message) {
		log.error(message);
	}

	public static void fatal(String message) {
		log.fatal(message);
	}

	public static void debug(String message) {
		log.debug(message);
	}
}
