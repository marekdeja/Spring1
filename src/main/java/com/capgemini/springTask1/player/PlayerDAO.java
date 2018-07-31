package com.capgemini.springTask1.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.springTask1.gamesHistory.GameEntity;

import database.DatabaseGamesHistory;
import database.DatabasePlayers;

@Repository
public class PlayerDAO {

	DatabasePlayers database = new DatabasePlayers();
	List<PlayerEntity> players = database.getPlayersList();

	DatabaseGamesHistory databaseHistory = new DatabaseGamesHistory();
	List<GameEntity> gamesHistory = databaseHistory.getGamesHistory();
	

	int loggedUserId = 1;

	public PlayerEntity findProfile(int loggedUserId) {
		return players.get(loggedUserId);
	}
	public void saveProfile(int loggedUserId, PlayerEntity newProfile) {
		PlayerEntity playerEntity = players.get(loggedUserId);
		playerEntity.setName(newProfile.getName());
		playerEntity.setSurname(newProfile.getSurname());
		playerEntity.setEmail(newProfile.getEmail());
		playerEntity.setPassword(newProfile.getPassword());
		playerEntity.setMotto(newProfile.getMotto());
	}

	public List findPlayers() {
		return players;
	}

	public List findHistory() {
		return gamesHistory;
	}
	
	public void removeGameFromCollection(List ownedGames){
		players.get(loggedUserId).setOwnedGames(ownedGames);
	}
	
	public void addGameToCollection(String newGame){
		players.get(loggedUserId).getOwnedGames().add(newGame);
	}
}
