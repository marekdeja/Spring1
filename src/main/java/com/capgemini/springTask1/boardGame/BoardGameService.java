package com.capgemini.springTask1.boardGame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardGameService {

	private final BoardGameMapper boardGameMapper;
	private final BoardGamesDAO gameDAO;

	@Autowired
	public BoardGameService (BoardGamesDAO gameDAO, BoardGameMapper boardGameMapper) {
		this.gameDAO = gameDAO;
		this.boardGameMapper = boardGameMapper;
	}

	public void addBoardGame(BoardGameDTO game) {
		gameDAO.addBoardGame(game.getName());
	}

	public List<BoardGameDTO> getAllBoardGames() {
		List allGames =	gameDAO.getAllBoardGames();
		return boardGameMapper.convert(allGames);
	}
}
