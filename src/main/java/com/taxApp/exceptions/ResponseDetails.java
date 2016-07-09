package com.taxApp.exceptions;

public class ResponseDetails {

	private String message;
	private int status;
	
	public ResponseDetails(String msg, int _status) {
		// TODO Auto-generated constructor stub
		this.message = msg;
		this.status = _status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String msg) {
		this.message = msg;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
