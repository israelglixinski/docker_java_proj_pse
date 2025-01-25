package com.plansul.pse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plansul.pse.entity.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long>  {
	public Optional<Empregado> findByDeMatricula(Long matricula);
}
