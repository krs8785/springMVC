package com.taxApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxApp.constants.Constants;
import com.taxApp.exceptions.ResponseDetails;
import com.taxApp.model.AppUser;
import com.taxApp.service.AppUserService;





@RestController
public class LoginController {	

	
	@Autowired
	AppUserService userService;
	ObjectMapper mapper = new ObjectMapper();


    @RequestMapping(value = "/login/userAuthenticate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> userAuthenticate(@RequestBody AppUser appUser) throws JsonProcessingException  {
    	AppUser isUserReal  = userService.findUserByEmailAndPassword(appUser.getEmail(),appUser.getPassword());
    	if(isUserReal != null){
    		return new ResponseEntity<Object>(new ResponseDetails(Constants.loginSuccessull, 200), HttpStatus.OK);
    	}else{
    		return new ResponseEntity<Object>(new ResponseDetails(Constants.loginFail, 401), HttpStatus.UNAUTHORIZED);
    	}
	}
    
	
	
	
   
	     
}
