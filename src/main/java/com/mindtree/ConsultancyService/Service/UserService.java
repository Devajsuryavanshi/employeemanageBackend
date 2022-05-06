package com.mindtree.ConsultancyService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.ConsultancyService.Entity.User;
import com.mindtree.ConsultancyService.Repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public boolean AuthenticateUser(User user) {

		User savedUser = repo.findByEmail(user.getEmail());

		if(savedUser == null)
			return false;
		else {
			if(user.getPassword().equals(savedUser.getPassword())) {
			    
				if(user.getRole().equals(savedUser.getRole())){
					return true;
				}
				else {
					return false;
				}
			}
			else
				return false;
		}
	}

}
