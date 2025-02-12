package com.plansul.pse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.SituacaoCandidatura;

@Repository
public interface SituacaoCandidaturaRepository extends JpaRepository<SituacaoCandidatura, Long>{

}
