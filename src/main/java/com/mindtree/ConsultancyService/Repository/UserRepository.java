package com.mindtree.ConsultancyService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.ConsultancyService.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
}
