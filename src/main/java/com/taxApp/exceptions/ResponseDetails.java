package com.taxApp.exceptions;

public class ResponseDetails {

	private String message;
	private int status;
	
	public ResponseDetails(String _err, int _status) {
		// TODO Auto-generated constructor stub
		this.message = _err;
		this.status = _status;
	}
	
	public String getError() {
		return message;
	}
	
	public void setError(String error) {
		this.message = error;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
