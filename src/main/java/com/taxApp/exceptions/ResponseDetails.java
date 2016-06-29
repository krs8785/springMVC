package com.taxApp.exceptions;

public class ResponseDetails {

	private String error;
	private int status;
	
	public ResponseDetails(String _err, int _status) {
		// TODO Auto-generated constructor stub
		this.error = _err;
		this.status = _status;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
