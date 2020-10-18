package br.com.pw.gof.common.exception;

public class EnvironmentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnvironmentException(String message) {
		super (message);
	}
	
	public EnvironmentException(String message, Exception exception) {
		super (message);
	}
}
