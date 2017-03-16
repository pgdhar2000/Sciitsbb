/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.exception;

public class BlockbusterException extends Exception {
	private static final long serialVersionUID = 6057638889793569346L;

	public BlockbusterException() {
		super();
	}

	public BlockbusterException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BlockbusterException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlockbusterException(String message) {
		super(message);
	}

	public BlockbusterException(Throwable cause) {
		super(cause);
	}
	
}
