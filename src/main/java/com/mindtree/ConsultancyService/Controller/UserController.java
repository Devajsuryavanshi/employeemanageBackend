package com.mindtree.ConsultancyService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ConsultancyService.Entity.User;
import com.mindtree.ConsultancyService.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/authUser")
	public boolean authenticateUser(@RequestBody User user) {

		return service.AuthenticateUser(user);
	}

}
