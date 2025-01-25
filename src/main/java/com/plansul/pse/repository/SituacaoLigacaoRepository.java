package com.plansul.pse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.SituacaoLigacao;

@Repository
public interface SituacaoLigacaoRepository extends JpaRepository<SituacaoLigacao, Long>{

}
