package com.capgemini.springTask1.Player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import database.DatabasePlayers;

@Repository
public class PlayerDAO {
	
	DatabasePlayers database = new DatabasePlayers();
	List <PlayerEntity> players = database.getPlayersList();
	int loggedUserId = 1;
	
	public PlayerEntity getProfile(int loggedUserId){
		return players.get(loggedUserId);
	}
	


	
}
