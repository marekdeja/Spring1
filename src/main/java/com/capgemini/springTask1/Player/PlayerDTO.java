package com.capgemini.springTask1.Player;

import java.util.List;

import com.capgemini.springTask1.enums.Level;

public class PlayerDTO {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String motto;
	private int gamesWon;
	private int gamesDrawn;
	private int gamesLost;
	private List ownedGames;
	
	public PlayerDTO(int id, String name, String surname, String email, String password, String motto, int gamesWon,
			int gamesDrawn, int gamesLost, List ownedGames) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.motto = motto;
		this.gamesWon = gamesWon;
		this.gamesDrawn = gamesDrawn;
		this.gamesLost = gamesLost;
		this.ownedGames = ownedGames;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	
	
	public int getGamesPlayed() {
		return gamesWon + gamesLost + gamesDrawn;
	}

	public int getGamesWon() {
		return gamesWon;
	}
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}
	public int getGamesDrawn() {
		return gamesDrawn;
	}
	public void setGamesDrawn(int gamesDrawn) {
		this.gamesDrawn = gamesDrawn;
	}
	public int getGamesLost() {
		return gamesLost;
	}
	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}

	public List getOwnedGames(){
		return this.ownedGames;
	}
	
	public void setOwnedGames(List ownedGames){
		this.ownedGames = ownedGames;
	}
	
	
	
	

}
