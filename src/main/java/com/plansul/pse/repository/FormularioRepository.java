package com.plansul.pse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.Formulario;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long> {

}
