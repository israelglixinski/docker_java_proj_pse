package com.plansul.pse.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plansul.pse.entity.Candidato;
import com.plansul.pse.entity.Empregado;
import com.plansul.pse.service.EmpregadoService;

@RestController
@RequestMapping("/empregados")
public class EmpregadoController {

	@Autowired
	EmpregadoService empregadoService;
	
	@GetMapping("/{matricula}")
	public ResponseEntity<Empregado> getCandidatoById(@PathVariable Long matricula) {
		Optional<Empregado> empregado = empregadoService.findByMatricula(matricula);
		if(empregado.isPresent()) {
			return ResponseEntity.ok(empregado.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}

}
