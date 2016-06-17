package com.taxApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxApp.service.appUserService;




@RestController
public class loginController {
	
	
	@Autowired
	appUserService userService;
	ObjectMapper mapper = new ObjectMapper();

	
	@RequestMapping(value = "/appUser", method = RequestMethod.GET)
	public String listAllUsers() {
		return "test";
	    
	}
	
	@RequestMapping(value = "/appUser/{email}", method = RequestMethod.GET)
    @ResponseBody
    public String getByID(@PathVariable String email) throws JsonProcessingException {
        return mapper.writeValueAsString(userService.findUserByEmail(email));
	}
    
	@RequestMapping(value = "/example", method = RequestMethod.POST)
    @ResponseBody
    public String postAppUser(@RequestParam String eg) throws JsonProcessingException {
		String ka = eg;
		System.out.println("asdasd");
		return "ok yes ";
		
    }
	
	
	
   
	     
}
