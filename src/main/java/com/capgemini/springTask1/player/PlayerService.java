package com.capgemini.springTask1.player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springTask1.boardGame.BoardGameDTO;
import com.capgemini.springTask1.boardGame.BoardGameEntity;
import com.capgemini.springTask1.boardGame.BoardGameService;
import com.capgemini.springTask1.enums.Level;
import com.capgemini.springTask1.gamesHistory.GameDTO;
import com.capgemini.springTask1.gamesHistory.GameEntity;
import com.capgemini.springTask1.gamesHistory.GameMapper;
import com.capgemini.springTask1.system.Login;

@Service
public class PlayerService {

	private final PlayerMapper playerMapper;
	private final PlayerDAO playerDAO;
	private final BoardGameService boardGameService;

	private final GameMapper gameMapper;

	int loggedUserId = Login.getLoginId();

	@Autowired
	public PlayerService(PlayerMapper playerMapper, PlayerDAO playerDAO, GameMapper gameMapper,
			BoardGameService boardGameService) {
		this.playerMapper = playerMapper;
		this.playerDAO = playerDAO;
		this.gameMapper = gameMapper;
		this.boardGameService = boardGameService;
	}

	// User Story 3

	public PlayerDTO getUserProfile() {
		PlayerEntity playerEntity = playerDAO.findProfile(loggedUserId);
		return playerMapper.convertInfo(playerEntity);
	}

	public void changeUserProfile(PlayerDTO playerDTO) {
		PlayerEntity newProfile = playerMapper.convertInfo(playerDTO);
		playerDAO.saveProfile(loggedUserId, newProfile);
	}

	// User Story 1

	public Level getUserLevel(int loggedUser) {
		PlayerEntity user = playerDAO.findProfile(loggedUserId);
		int gamesWon = user.getGamesWon();

		if (gamesWon > 45) {
			return Level.PRO;
		} else if (gamesWon > 15) {
			return Level.MEDIUM;
		} else {
			return Level.BEGINNER;
		}
	}

	public List <PlayerDTO> getAllPlayers() {
		List <PlayerDTO> players = playerMapper.convert(playerDAO.findPlayers());
		return players;
	}

	public void getStatistics(int loggedUser) {
		this.getUserProfile();
	}

	/**
	 * I compare two players in ArrayList, if next has more points than current,
	 * then change positions and come back to index 0 of iterated list and start
	 * iterating again until the ArrayList in correct order
	 * 
	 * @return ranking position of user among all players
	 */
	public int getCurrentRankingPosition() {
		List players = playerDAO.findPlayers();

		for (int i = 0; i < players.size() - 1; i++) {
			PlayerEntity player = (PlayerEntity) players.get(i);
			PlayerEntity nextPlayer = (PlayerEntity) players.get(i + 1);
			PlayerEntity tempPlayer = (PlayerEntity) players.get(i);

			int pointsPlayer = player.getGamesWon() * 3 + player.getGamesDrawn() * 1;
			int pointsNextPlayer = nextPlayer.getGamesWon() * 3 + nextPlayer.getGamesDrawn() * 1;

			if (pointsPlayer < pointsNextPlayer) {
				players.set(i, nextPlayer);
				players.set(i + 1, tempPlayer);
				i = 0;
			}
		}

		for (int i = 0; i < players.size(); i++) {
			if (((PlayerEntity) players.get(i)).getId() == loggedUserId) {
				int indexPosition = players.indexOf(players.get(i));
				return indexPosition + 1;
			}
		}
		return 0;
	}

	public List getHistory() {
		List<GameDTO> playerHistory = new ArrayList<>();
		List<GameEntity> wholeHistory = playerDAO.findHistory();

		for (int i = 0; i < wholeHistory.size(); i++) {
			int playerId = ((GameEntity) wholeHistory.get(i)).getPlayerId();
			if (playerId == loggedUserId) {
				GameDTO convertedGame = gameMapper.convert((GameEntity) wholeHistory.get(i));
				playerHistory.add(convertedGame);
			}
		}
		return playerHistory;
	}

	// User story 2

	public List getUserGameColection() {
		PlayerDTO playerDTO = this.getUserProfile();

		return playerDTO.getOwnedGames();
	};

	public void removeGameFromCollection(String gameToRemove) {
		List ownedGames = this.playerDAO.findProfile(loggedUserId).getOwnedGames();
		ownedGames.remove(gameToRemove);
		this.playerDAO.removeGameFromCollection(ownedGames);
	}

	// no mapper because of String
	public void addGame(String newGame) {
		List<BoardGameDTO> allBoardGames = boardGameService.getAllBoardGames();
		if (newGame != null) {
			for (int i = 0; i < allBoardGames.size(); i++) {
				if (!(allBoardGames.get(i).getName().equals(newGame))) {
					BoardGameDTO newBoardGameDTO = new BoardGameDTO(newGame);
					boardGameService.addBoardGame(newBoardGameDTO);
				}
				playerDAO.addGameToCollection(newGame);
			}

		}

	}

	public List <PlayerDTO> searchParas(String name, String surname, String email) {
		List<PlayerDTO> allPlayers = this.getAllPlayers();

		if (name != null) {
			allPlayers = allPlayers.stream().filter(x -> name.equals(x.getName())).collect(Collectors.toList());
		}
		if (surname != null) {
			allPlayers = allPlayers.stream().filter(x -> surname.equals(x.getSurname())).collect(Collectors.toList());
		}
		if (email != null) {
			allPlayers = allPlayers.stream().filter(x -> email.equals(x.getEmail())).collect(Collectors.toList());
		}
		if (name == "" && surname == "" && email == "") {
			throw new PlayerNotFoundException();
		}
		if (allPlayers==null){
			throw new PlayerNotFoundException();
		}
		return allPlayers;

	}

}

