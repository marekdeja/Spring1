package com.capgemini.springTask1.player;

import java.util.Date;

public class Error {
	private Date date;
	private String error;

	public Error(String error) {
		this.date = new Date();
		this.error = error;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
