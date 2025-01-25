package com.plansul.pse.controller;

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

import com.plansul.pse.entity.Formulario;
import com.plansul.pse.service.FormularioService;
  
@RestController
@RequestMapping("/api/formularios")
public class FormularioController {
	
	@Autowired
	private FormularioService formularioService; 
	 
	
	@GetMapping("/{id}") 
	public ResponseEntity<Formulario> getFormularioById(@PathVariable Long id) {  
		return formularioService.findFormulario(id); 
	}
	
	
	@PostMapping 
	public Formulario createFormulario(@RequestBody Formulario formulario) { 
		return formularioService.createFormulario(formulario); 
	}
	

    @PutMapping("/{id}")
    public ResponseEntity<Formulario> updateFormulario(@PathVariable Long id, @RequestBody Formulario formularioDetails) {
        Formulario updatedFormulario = formularioService.updateFormulario(id, formularioDetails);
        return ResponseEntity.ok(updatedFormulario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormulario(@PathVariable Long id) {
        formularioService.deleteFormulario(id);
        return ResponseEntity.noContent().build();
    }
}
