package com.plansul.pse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.Empregado;
import com.plansul.pse.repository.EmpregadoRepository;

@Service
public class EmpregadoService {

	
	 @Autowired
	 EmpregadoRepository empregadoRepository;
	 
	 
	 public List<Empregado> findAll(){
		 return empregadoRepository.findAll();
	 }
	
	 public Optional<Empregado> findByMatricula(Long matricula){
		 return empregadoRepository.findByDeMatricula(matricula);
	 }
}
