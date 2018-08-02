package com.capgemini.springTask1.player;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@Controller
public class PlayerServiceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceController.class);
	
	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value="/getuserprofile", method = RequestMethod.GET)
	@ResponseBody
	public PlayerDTO getUserProfile(){
		return playerService.getUserProfile();
	}
	
	@RequestMapping(value="/changeprofile", method = RequestMethod.POST)
	@ResponseBody
	public PlayerDTO changeProfile(@RequestBody PlayerDTO newProfile){
		playerService.changeUserProfile(newProfile);
		return newProfile;
	}
	
	
	@RequestMapping (value="/finduser", method = RequestMethod.POST)
	@ResponseBody
	public List <PlayerDTO> findUsers (@RequestBody PlayerDTO userProfile) throws PlayerNotFoundException{
		return playerService.searchParas(userProfile.getName(), userProfile.getSurname(), userProfile.getEmail());
	}
	
}