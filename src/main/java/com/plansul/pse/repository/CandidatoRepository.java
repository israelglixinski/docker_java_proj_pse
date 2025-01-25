package com.plansul.pse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
