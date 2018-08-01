package com.capgemini.springTask1.player;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlayerServiceController {
	
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
	
	
	@RequestMapping (value="/finduser", method = RequestMethod.GET)
	@ResponseBody
	public PlayerDTO findUsers (@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email) throws Exception{
		return playerService.searchParas(name, surname, email);
	}

}