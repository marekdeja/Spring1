package com.capgemini.springTask1.Player;

import java.util.List;

import com.capgemini.springTask1.BoardGame.BoardGameEntity;

public class PlayerMapper {

	public PlayerDTO convertInfo(PlayerEntity playerEntity) {

		String name = playerEntity.getName();
		String surname = playerEntity.getSurname();
		String email = playerEntity.getEmail();
		String password = playerEntity.getPassword();
		String motto = playerEntity.getMotto();

		PlayerDTO playerDTO = null;
		playerDTO.setName(name);
		playerDTO.setSurname(surname);
		playerDTO.setEmail(email);
		playerDTO.setPassword(password);
		playerDTO.setMotto(motto);

		return playerDTO;
	}

	public PlayerEntity convertInfo(PlayerDTO playerDTO) {

		String name = playerDTO.getName();
		String surname = playerDTO.getSurname();
		String email = playerDTO.getEmail();
		String password = playerDTO.getPassword();
		String motto = playerDTO.getMotto();

		PlayerEntity playerEntity = null;
		playerEntity.setName(name);
		playerEntity.setSurname(surname);
		playerEntity.setEmail(email);
		playerEntity.setPassword(password);
		playerEntity.setMotto(motto);

		return playerEntity;
	}

	public List convert(List playersDTO) {
		return playersDTO;
	}
}
