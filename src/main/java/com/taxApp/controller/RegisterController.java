package com.taxApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxApp.model.AppUser;
import com.taxApp.service.AppUserService;

@RestController
public class RegisterController {

	@Autowired
	AppUserService userService;
	ObjectMapper mapper = new ObjectMapper();
	

	@RequestMapping(value = "/register/insertNewUser", method = RequestMethod.POST)
    public String insertNewUser(@RequestBody AppUser appUser) throws JsonProcessingException  {
		try{
			AppUser checkUserPresent = userService.findUserByEmail(appUser.getEmail());
			if(checkUserPresent!=null && checkUserPresent.getEmail().equals(appUser.getEmail())){
				return  mapper.writeValueAsString("a");
			}else{
				long userId = userService.insertAppUser(appUser);
				return  mapper.writeValueAsString("a");
			}
			
		}catch(Exception e){
			return  mapper.writeValueAsString("a");
		}
			
		
    }
}
