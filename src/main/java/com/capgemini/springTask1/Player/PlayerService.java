package com.capgemini.springTask1.Player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springTask1.System.Login;
import com.capgemini.springTask1.enums.Level;

import GamesHistory.GameDTO;
import GamesHistory.GameEntity;
import GamesHistory.GameMapper;


@Service
public class PlayerService {
	
	private final PlayerMapper playerMapper;
	private final PlayerDAO playerDAO;
	private final GameMapper gameMapper;
	
	int loggedUserId = Login.getLoginId();
	
	
	@Autowired
	public PlayerService(PlayerMapper playerMapper, PlayerDAO playerDAO, GameMapper gameMapper) {
		this.playerMapper = playerMapper;
		this.playerDAO = playerDAO;
		this.gameMapper= gameMapper;
	}
	
	//User Story 3
	
	public PlayerDTO getUserProfile(){
		PlayerEntity playerEntity = playerDAO.getProfile(loggedUserId);
		return playerMapper.convertInfo(playerEntity);
	}
	
	public PlayerEntity changeUserProfile(PlayerDTO playerDTO){
		return  playerMapper.convertInfo(playerDTO);
		
	}
	
	//User Story 1
	
	public Level getUserLevel(int loggedUser){
		PlayerEntity user = playerDAO.getProfile(loggedUserId);
		int gamesWon = user.getGamesWon();
		int gamesPlayed = user.getGamesPlayed();
		
		if (gamesWon>45){
			return Level.PRO;
		}
		else if (gamesWon>15){
			return Level.MEDIUM;
		}
		else{
			return Level.BEGINNER;
		}
	}
	
	public void getStatistics(int loggedUser){
		this.getUserProfile();
	}
	
	public int getCurrentRankingPosition(){
		List players = playerDAO.getPlayers();
		
		for (int i=0;i<players.size()-1;i++){
			PlayerEntity player = (PlayerEntity) players.get(i);
			PlayerEntity nextPlayer = (PlayerEntity) players.get(i+1);
			PlayerEntity tempPlayer = (PlayerEntity) players.get(i);
			
			int pointsPlayer = player.getGamesWon()*3 + player.getGamesDrawn()*1;
			int pointsNextPlayer = nextPlayer.getGamesWon()*3 + nextPlayer.getGamesDrawn()*1;
			
			if (pointsPlayer<pointsNextPlayer){
				players.set(i, nextPlayer);
				i = 0;
			}
		}
		
		
		for(int i=0; i<players.size(); i++){
			if(((PlayerDTO) players.get(i)).getId()==loggedUserId){
				return players.indexOf(players.get(i));
			}
		}
		return 0;	
	}
	
	public List getHistory(){
		List <GameDTO> playerHistory=new ArrayList<>();
		List <GameEntity> wholeHistory = playerDAO.getHistory();
		
		for (int i=0; i<wholeHistory.size(); i++){
			int playerId = ((GameEntity) wholeHistory.get(i)).getPlayerId();
			if (playerId==loggedUserId) {
				GameDTO convertedGame = gameMapper.convert((GameEntity) wholeHistory.get(i));
				playerHistory.add(convertedGame);
			}
		}
		return playerHistory;
	}

	//User story 2
	
	public List getUserGameColection(){
		PlayerDTO playerDTO = this.getUserProfile();
		
		return playerDTO.getOwnedGames();
	};
	
	public void removeGameFromCollection(){
		List 
	}
	
	
	
}
