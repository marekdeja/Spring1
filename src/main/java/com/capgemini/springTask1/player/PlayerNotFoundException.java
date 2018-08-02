package com.capgemini.springTask1.player;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -43443543545L;

	public PlayerNotFoundException() {
		super("No such a player!");
	}
	
	public PlayerNotFoundException(String message) {
		super("No such a player! " + message);
	}
}
