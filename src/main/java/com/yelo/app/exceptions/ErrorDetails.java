/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.exceptions;

import java.time.LocalDateTime;

/**
 *
 * @author Ahmed Hafez
 */
public class ErrorDetails {

	private String message;
	private String path;
	private LocalDateTime timeestamp;
	
	
	
	
	public ErrorDetails(String message, String path,LocalDateTime timeestamp) {
		this.message = message;
		this.path = path;
	
		this.timeestamp = timeestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public LocalDateTime getTimeestamp() {
		return timeestamp;
	}
	public void setTimeestamp(LocalDateTime timeestamp) {
		this.timeestamp = timeestamp;
	}
	
	
}