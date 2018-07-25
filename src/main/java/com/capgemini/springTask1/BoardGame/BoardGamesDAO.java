package com.capgemini.springTask1.BoardGame;

import java.util.List;

import org.springframework.stereotype.Repository;

import database.DatabaseBoardGames;

@Repository
public class BoardGamesDAO {
	DatabaseBoardGames databaseBoardGames = new DatabaseBoardGames();
	List<BoardGameEntity> boardGames = databaseBoardGames.getBoardGamesList();
	
	public void addBoardGame(String name){
		if (boardGames.indexOf(name)==-1){
		boardGames.add(new BoardGameEntity(name));
		}
	}
	
	public List getAllBoardGames(){
		return boardGames;
	}
}
