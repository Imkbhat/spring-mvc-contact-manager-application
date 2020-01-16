package main.webapp.com.kiran.luv2code.exception;

public class UserBlockedException extends Exception {
	
	/**
	 * Creates User Object without Error Description
	 */
	
	public UserBlockedException() {

	}
	
	/**
	 * Creates User Object with Error Description
	 */
	
	public UserBlockedException(String errorDesc) {
		super(errorDesc);
	}
	
}
