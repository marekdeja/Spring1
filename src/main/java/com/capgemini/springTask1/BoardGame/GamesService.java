package com.capgemini.springTask1.BoardGame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesService {

	private final BoardGameMapper boardGameMapper;
	private final BoardGamesDAO gameDAO;

	@Autowired
	public GamesService (BoardGamesDAO gameDAO, BoardGameMapper boardGameMapper) {
		this.gameDAO = gameDAO;
		this.boardGameMapper = boardGameMapper;
	}

	public void addBoardGame(BoardGameDTO game) {
		gameDAO.addBoardGame(game.getName());
	}

	public List getAllBoardGames() {
		List allGames =	gameDAO.getAllBoardGames();
		return boardGameMapper.convert(allGames);
	}
}
