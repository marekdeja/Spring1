package com.capgemini.springTask1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.springTask1.boardGame.BoardGameEntity;
import com.capgemini.springTask1.boardGame.BoardGameMapper;
import com.capgemini.springTask1.boardGame.BoardGameService;
import com.capgemini.springTask1.boardGame.BoardGamesDAO;
import com.capgemini.springTask1.gamesHistory.GameMapper;
import com.capgemini.springTask1.player.PlayerDAO;
import com.capgemini.springTask1.player.PlayerDTO;
import com.capgemini.springTask1.player.PlayerEntity;
import com.capgemini.springTask1.player.PlayerMapper;
import com.capgemini.springTask1.player.PlayerService;
import static org.junit.Assert.*;

//@RunWith(SpringRunner.class, )

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SpringTask1ApplicationTests {

	@Mock
	PlayerDAO playerDAO;
	GameMapper gameMapper;
	BoardGameService boardGameService;
	
//	@InjectMocks
//	PlayerService playerService;

	@Test
	public void getProfileOneShouldBeMarek() {
		// given
		PlayerMapper playerMapper = new PlayerMapper();

		PlayerService playerService = new PlayerService(playerMapper, playerDAO, gameMapper, boardGameService);
		List<BoardGameEntity> ownedGamesPlayer1 = new ArrayList<>();
		ownedGamesPlayer1.add(new BoardGameEntity("Chess"));
		ownedGamesPlayer1.add(new BoardGameEntity("Witcher"));

		PlayerEntity profile = new PlayerEntity(1, "Marek", "Flaming", "marekflaming@cp.pl", "1234", "I like oranges",
				100, 0, 0, ownedGamesPlayer1);

		Mockito.when(playerDAO.findProfile(1)).thenReturn(profile);
		// when
		PlayerDTO result = playerService.getUserProfile();
		// then
		assertEquals("Marek", result.getName());

	}

//	@Test
//	public void arraySizeShouldBeSmaller(){
//		//given
//PlayerMapper playerMapper = new PlayerMapper();
//		PlayerService playerService = new PlayerService(playerMapper, playerDAO, gameMapper, boardGameService);
//		
//		List <BoardGameEntity> ownedGamesPlayer1 = new ArrayList<> ();
//		ownedGamesPlayer1.add(new BoardGameEntity("Chess"));
//		ownedGamesPlayer1.add(new BoardGameEntity("Witcher"));
//		
//		Mockito.when(playerDAO.removeGameFromCollection(ownedGamesPlayer1)).thenReturn(1);
//		//when
//		
//		playerService.removeGameFromCollection("Chess");
//		
//		//then
//		
//	}
	
	@Test
	public void rankingShouldBeMarekFirst(){
		//given
		PlayerMapper playerMapper = new PlayerMapper();
		PlayerService playerService = new PlayerService(playerMapper, playerDAO, gameMapper, boardGameService);
		
		
		List <BoardGameEntity> ownedGamesPlayer0 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Monopoly"));
		ownedGamesPlayer0.add(new BoardGameEntity("Chess"));
		ownedGamesPlayer0.add(new BoardGameEntity("Witcher"));
		
		List <BoardGameEntity> ownedGamesPlayer1 = new ArrayList<>();
		ownedGamesPlayer1.add(new BoardGameEntity("Chess"));
		ownedGamesPlayer1.add(new BoardGameEntity("Witcher"));
		
		List <BoardGameEntity> ownedGamesPlayer2 = new ArrayList<>();
		ownedGamesPlayer2.add(new BoardGameEntity("Chess"));
		
		List <BoardGameEntity> ownedGamesPlayer3 = new ArrayList<>();
		ownedGamesPlayer3.add(new BoardGameEntity("Warhammer"));
		
		List <PlayerEntity> players = new ArrayList<>();
		players.add(new PlayerEntity(0, "Tomek", "Kowalski", "tomekkowalski@cp.pl", "1234","I like oranges", 1, 5, 4, ownedGamesPlayer0));
		players.add(new PlayerEntity(1, "Marek", "Flaming", "marekflaming@cp.pl", "1234","I like oranges", 100, 0, 0, ownedGamesPlayer1));
		players.add(new PlayerEntity(2, "Bartek", "Milewski", "bratekmilewski@cp.pl", "1234","I like oranges", 10, 3, 6, ownedGamesPlayer2));
		players.add(new PlayerEntity(3, "Laura", "Stryka", "laurastryka@cp.pl", "1234","I like oranges", 20, 8, 3, ownedGamesPlayer3));
		
		Mockito.when(playerDAO.findPlayers()).thenReturn(players);
		//when
		int position = playerService.getCurrentRankingPosition();
		
		
		//then
		assertEquals(1, position);
		
	}

}
