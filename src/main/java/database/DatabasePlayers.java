package database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.springTask1.BoardGame.BoardGameEntity;
import com.capgemini.springTask1.Player.PlayerEntity;

public class DatabasePlayers {
	
	
	private List players;

	public DatabasePlayers(){
		List <PlayerEntity> players = new ArrayList<>();
		
		List <BoardGameEntity> ownedGamesPlayer0 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Monopoly"));
		ownedGamesPlayer0.add(new BoardGameEntity("Chess"));
		ownedGamesPlayer0.add(new BoardGameEntity("Witcher"));
		
		List <BoardGameEntity> ownedGamesPlayer1 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Chess"));
		ownedGamesPlayer0.add(new BoardGameEntity("Witcher"));
		
		List <BoardGameEntity> ownedGamesPlayer2 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Chess"));
		
		List <BoardGameEntity> ownedGamesPlayer3 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Warhammer"));
		
		List <BoardGameEntity> ownedGamesPlayer4 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Monopoly"));
		ownedGamesPlayer0.add(new BoardGameEntity("Chess"));
		ownedGamesPlayer0.add(new BoardGameEntity("Witcher"));
		
		List <BoardGameEntity> ownedGamesPlayer5 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Monopoly"));
		ownedGamesPlayer0.add(new BoardGameEntity("Chess"));
		ownedGamesPlayer0.add(new BoardGameEntity("Warhammer"));
		
		List <BoardGameEntity> ownedGamesPlayer6 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Warhammer"));
		ownedGamesPlayer0.add(new BoardGameEntity("Witcher"));
		
		List <BoardGameEntity> ownedGamesPlayer7 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Monopoly"));
		ownedGamesPlayer0.add(new BoardGameEntity("Chess"));
		ownedGamesPlayer0.add(new BoardGameEntity("Witcher"));
		
		List <BoardGameEntity> ownedGamesPlayer8 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Monopoly"));
		ownedGamesPlayer0.add(new BoardGameEntity("Chess"));
		
		List <BoardGameEntity> ownedGamesPlayer9 = new ArrayList<>();
		ownedGamesPlayer0.add(new BoardGameEntity("Monopoly"));


		players.add(new PlayerEntity(0, "Tomek", "Kowalski", "tomekkowalski@cp.pl", "1234","I like oranges", 1, 5, 4, ownedGamesPlayer0));
		players.add(new PlayerEntity(1, "Marek", "Flaming", "marekflaming@cp.pl", "1234","I like oranges", 100, 0, 0, ownedGamesPlayer1));
		players.add(new PlayerEntity(2, "Bartek", "Milewski", "bratekmilewski@cp.pl", "1234","I like oranges", 10, 3, 6, ownedGamesPlayer2));
		players.add(new PlayerEntity(3, "Laura", "Stryka", "laurastryka@cp.pl", "1234","I like oranges", 20, 8, 3, ownedGamesPlayer3));
		players.add(new PlayerEntity(4, "Jola", "Sroka", "jolasroka@cp.pl", "1234","I like oranges", 9, 9, 2, ownedGamesPlayer4));
		players.add(new PlayerEntity(5, "Piotr", "Bliski", "piotrbliski@cp.pl", "1234","I like oranges", 0, 0, 40, ownedGamesPlayer5));
		players.add(new PlayerEntity(6, "Zofia", "Kora", "zofiakora@cp.pl", "1234","I like oranges", 10, 9, 41, ownedGamesPlayer6));
		players.add(new PlayerEntity(7, "Rafal", "Lejek", "rafallejek@cp.pl", "1234","I like oranges", 30, 5, 0, ownedGamesPlayer7));
		players.add(new PlayerEntity(8, "Edyta", "Kapusta", "edytakapusta@cp.pl", "1234","I like oranges", 16, 20, 23, ownedGamesPlayer8));
		players.add(new PlayerEntity(9, "Agata", "Zadna", "agatazadna@cp.pl", "1234","I like oranges", 3, 11, 7, ownedGamesPlayer9));
		
	}
	
	public List getPlayersList(){
	return this.players;
	}
	
	
}
