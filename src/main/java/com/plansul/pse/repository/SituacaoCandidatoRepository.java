package com.plansul.pse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.SituacaoCandidato;

@Repository
public interface SituacaoCandidatoRepository extends JpaRepository<SituacaoCandidato, Long>{

}
