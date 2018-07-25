package com.capgemini.springTask1.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springTask1.System.Login;


@Service
public class UserService {
	
	private final PlayerMapper playerMapper;
	private final PlayerDAO playerDAO;
	int loggedUserId = Login.getLoginId();
	
	
	@Autowired
	public UserService(PlayerMapper playerMapper, PlayerDAO playerDAO) {
		this.playerMapper = playerMapper;
		this.playerDAO = playerDAO;
	}
	
	//User Story 3
	
	public String getUserName(){
		PlayerEntity userProfile = playerDAO.getProfile(loggedUserId);
		return userProfile.getName();
	}
	
	public String getUserSurname(){
		PlayerEntity userProfile = playerDAO.getProfile(loggedUserId);
		return userProfile.getSurname();
	}
	public String getUserPassword(){
		PlayerEntity userProfile = playerDAO.getProfile(loggedUserId);
		return userProfile.getPassword();
	}
	public String getUserMotto(){
		PlayerEntity userProfile = playerDAO.getProfile(loggedUserId);
		return userProfile.getMotto();
	}
	
	public void setUserName(String newName){
		
	}

	
	
	
	
}
