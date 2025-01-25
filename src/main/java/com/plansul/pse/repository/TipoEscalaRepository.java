package com.plansul.pse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.TipoEscala;

@Repository
public interface TipoEscalaRepository extends JpaRepository<TipoEscala, Long> {

}
