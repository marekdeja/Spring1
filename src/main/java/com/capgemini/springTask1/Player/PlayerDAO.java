package com.capgemini.springTask1.Player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import GamesHistory.GameEntity;
import database.DatabaseGamesHistory;
import database.DatabasePlayers;

@Repository
public class PlayerDAO {

	DatabasePlayers database = new DatabasePlayers();
	List<PlayerEntity> players = database.getPlayersList();

	DatabaseGamesHistory databaseHistory = new DatabaseGamesHistory();
	List<GameEntity> gamesHistory = databaseHistory.getGamesHistory();

	int loggedUserId = 1;

	public PlayerEntity getProfile(int loggedUserId) {
		return players.get(loggedUserId);
	}

	public void setProfile(int loggedUserId, PlayerEntity newProfile) {
		players.get(loggedUserId).setName(newProfile.getName());
		players.get(loggedUserId).setSurname(newProfile.getSurname());
		players.get(loggedUserId).setEmail(newProfile.getEmail());
		players.get(loggedUserId).setPassword(newProfile.getPassword());
		players.get(loggedUserId).setMotto(newProfile.getMotto());
	}

	public List getPlayers() {
		return players;
	}

	public List getHistory() {
		return gamesHistory;
	}
}
