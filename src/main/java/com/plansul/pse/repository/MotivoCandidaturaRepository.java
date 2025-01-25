package com.plansul.pse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.MotivoCandidatura;

@Repository
public interface MotivoCandidaturaRepository extends JpaRepository<MotivoCandidatura, Long> {

}
