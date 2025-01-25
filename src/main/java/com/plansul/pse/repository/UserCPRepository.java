package com.plansul.pse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.User;
import com.plansul.pse.entity.UserCP;

@Repository
public interface UserCPRepository extends JpaRepository<UserCP, Long> {
	
	public Optional<UserCP> findByDeMatricula(Long deMatricula);
	
} 
