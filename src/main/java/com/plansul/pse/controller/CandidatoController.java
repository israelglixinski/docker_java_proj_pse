package com.plansul.pse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plansul.pse.entity.Candidato;
import com.plansul.pse.service.CandidatoService;


@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {


	@Autowired
	private CandidatoService candidatoService;

	@GetMapping
	public ResponseEntity<List<Candidato>> getAllCandidatos() {
		return candidatoService.findAllCandidatos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Candidato> getCandidatoById(@PathVariable Long id) {
		return candidatoService.findCandidato(id);
	}
	
	@PostMapping
	public ResponseEntity<Candidato> createCandidato(@RequestBody Candidato candidato) {
		return candidatoService.createCandidato(candidato);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Candidato> updateCandidato(@PathVariable Long id, @RequestBody Candidato candidatoDetails) {
		Candidato updatedCandidato = candidatoService.updateCandidato(id, candidatoDetails);
		return ResponseEntity.ok(updatedCandidato);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCandidato(@PathVariable Long id) {
		candidatoService.deleteCandidato(id);
		return ResponseEntity.noContent().build();
	}
}
