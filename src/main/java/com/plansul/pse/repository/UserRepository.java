package com.plansul.pse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	  
	public Optional<User> findByMatricula(String matricula);
	
}
