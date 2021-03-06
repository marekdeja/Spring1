package com.capgemini.springTask1.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capgemini.springTask1.boardGame.BoardGameEntity;

@Component
public class PlayerMapper {

	public PlayerDTO convertInfo(PlayerEntity playerEntity) {

		String name = playerEntity.getName();
		String surname = playerEntity.getSurname();
		String email = playerEntity.getEmail();
		String password = playerEntity.getPassword();
		String motto = playerEntity.getMotto();

		PlayerDTO playerDTO = new PlayerDTO(name, surname, email, password, motto);
		return playerDTO;
	}

	public PlayerEntity convertInfo(PlayerDTO playerDTO) {

		String name = playerDTO.getName();
		String surname = playerDTO.getSurname();
		String email = playerDTO.getEmail();
		String password = playerDTO.getPassword();
		String motto = playerDTO.getMotto();

		PlayerEntity playerEntity = new PlayerEntity(name, surname, email, password, motto);
		return playerEntity;
	}

	public List <PlayerDTO> convert(List <PlayerEntity>players) {
		List <PlayerDTO> playersDTO = new ArrayList<>();
		for (int i=0; i<players.size(); i++){
			PlayerEntity playerEntity = players.get(i);
			PlayerDTO playerDTO = this.convertInfo(playerEntity);
			playersDTO.add(playerDTO);
		}
		return playersDTO;
	}
	
	
}
