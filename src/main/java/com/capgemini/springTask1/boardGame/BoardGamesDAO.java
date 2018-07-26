package com.capgemini.springTask1.boardGame;

import java.util.List;

import org.springframework.stereotype.Repository;

import database.DatabaseBoardGames;

@Repository
public class BoardGamesDAO {
	DatabaseBoardGames databaseBoardGames = new DatabaseBoardGames();
	List<BoardGameEntity> boardGames = databaseBoardGames.getBoardGamesList();
	
	public void addBoardGame(String name){
		BoardGameEntity addedChecker = new BoardGameEntity(name);
		if (boardGames.indexOf(addedChecker)==-1){
		boardGames.add(addedChecker);
		}
	}
	
	public List<BoardGameEntity> getAllBoardGames(){
		return boardGames;
	}
}
