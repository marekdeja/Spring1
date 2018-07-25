package com.capgemini.springTask1.Player;

import java.util.List;

import com.capgemini.springTask1.BoardGame.BoardGameEntity;

public class PlayerMapper {
	public PlayerEntity convert(PlayerEntity playerDTO){
		return playerDTO;
	}
	public List convert(List playersDTO){
		return playersDTO;
	}
}
