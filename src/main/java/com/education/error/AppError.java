package com.education.error;

import org.springframework.http.HttpStatus;

public class AppError extends RuntimeException {
	private static final long serialVersionUID = 1L;
    private String msg;
    private HttpStatus status;
	public AppError(String msg, HttpStatus status){
		this.msg = msg;
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
