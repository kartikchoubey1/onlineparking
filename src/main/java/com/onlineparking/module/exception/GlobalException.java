package com.onlineparking.module.exception;

public class GlobalException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public GlobalException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
