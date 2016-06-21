package com.taxApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginController {
	
	
	@Autowired
	AppUserService userService;
	ObjectMapper mapper = new ObjectMapper();

	//@CrossOrigin(origins = "http://localhost:63342")
	@RequestMapping(value = "/appUser", method = RequestMethod.GET)
	public String listAllUsers() throws JsonProcessingException {
		System.out.println("reached here");
		return mapper.writeValueAsString("aa");
	    
	}
	
	/*@RequestMapping(value = "/appUser/{email}", method = RequestMethod.GET)
    @ResponseBody
    public String getByID(@PathVariable String email) throws JsonProcessingException {
        return mapper.writeValueAsString(userService.findUserByEmail(email));
	}*/
    
	@RequestMapping(value = "/appUser/insertNewUser", method = RequestMethod.POST)
    @ResponseBody
    public String insertNewUser(@RequestBody AppUser appUser) throws JsonProcessingException {
		System.out.println("creating user....");
		long userID = userService.insertAppUser(appUser);
		return mapper.writeValueAsString("created");
		
    }
	
	
	
   
	     
}
