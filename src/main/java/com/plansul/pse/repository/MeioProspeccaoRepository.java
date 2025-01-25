package com.plansul.pse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.MeioProspeccao;

@Repository
public interface MeioProspeccaoRepository extends JpaRepository<MeioProspeccao, Long>{

}
