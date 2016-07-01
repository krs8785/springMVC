package com.taxApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxApp.constants.Constants;
import com.taxApp.exceptions.ResponseDetails;
import com.taxApp.model.AppUser;
import com.taxApp.service.AppUserService;

@RestController
public class RegisterController {

	@Autowired
	AppUserService userService;
	ObjectMapper mapper = new ObjectMapper();


	@RequestMapping(value = "/register/insertNewUser", method = RequestMethod.POST)
	public ResponseEntity<?> insertNewUser(@RequestBody AppUser appUser) throws JsonProcessingException  {
		try{
			AppUser checkUserPresent = userService.findUserByEmail(appUser.getEmail());
			if(checkUserPresent!=null && checkUserPresent.getEmail().equals(appUser.getEmail())){

				return new ResponseEntity<Object>(new ResponseDetails(Constants.emailAlreadyRegistered, 409), HttpStatus.CONFLICT);
			}else{
				long userId = userService.insertAppUser(appUser);
				return new ResponseEntity<Object>(new ResponseDetails(Constants.userCreatedSuccessfully, 200), HttpStatus.OK);
			}
		}catch(Exception e){
			return new ResponseEntity<Object>(new ResponseDetails(Constants.errorOccured, 500), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
