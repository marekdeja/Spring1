package com.capgemini.springTask1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.springTask1.boardGame.BoardGameEntity;
import com.capgemini.springTask1.boardGame.BoardGameMapper;
import com.capgemini.springTask1.boardGame.BoardGameService;
import com.capgemini.springTask1.boardGame.BoardGamesDAO;
import com.capgemini.springTask1.gamesHistory.GameMapper;
import com.capgemini.springTask1.player.PlayerDAO;
import com.capgemini.springTask1.player.PlayerEntity;
import com.capgemini.springTask1.player.PlayerMapper;
import com.capgemini.springTask1.player.PlayerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTask1ApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	//dlaczego przy debugu mi sie hoursService pokazuje?
	public void positionInRankingIsOne(){
		//given
		PlayerMapper playerMapper = new PlayerMapper();
		PlayerDAO playerDAO = new PlayerDAO();
		GameMapper gameMapper = new GameMapper();
		BoardGamesDAO gameDAO = new BoardGamesDAO();
		BoardGameMapper boardGameMapper = new BoardGameMapper();
		BoardGameService boardGameService = new BoardGameService(gameDAO , boardGameMapper);
		
		PlayerService playerService = new PlayerService(playerMapper, playerDAO, gameMapper, boardGameService);
		
		//when
		int position = playerService.getCurrentRankingPosition();
		
		//then
		assertEquals(position, 1);
	}

}
