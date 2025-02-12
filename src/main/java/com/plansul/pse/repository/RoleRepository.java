package com.plansul.pse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	
	public Optional<Role> findByAuthority(String authority);
}
