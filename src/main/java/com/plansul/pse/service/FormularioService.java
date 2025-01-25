package com.plansul.pse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.Formulario;
import com.plansul.pse.repository.FormularioRepository;

import jakarta.transaction.Transactional;

@Service
public class FormularioService {

	@Autowired
	FormularioRepository formularioRepository;

 
	public ResponseEntity<Formulario> findFormulario(Long coFormulario){
		Optional<Formulario> formulario = formularioRepository.findById(coFormulario);
		if(formulario.isPresent()) {
			return new ResponseEntity<Formulario>(
					formulario.get()
					,HttpStatus.OK
					);
		}else {
			return new ResponseEntity<Formulario>(HttpStatus.NO_CONTENT);

		}

	}


	@Transactional
	public Formulario updateFormulario(Long id, Formulario updatedFormulario) {
		Formulario formulario = formularioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Formulario not found with id " + id));

		formulario.setResponsaveisLigacao(updatedFormulario.getResponsaveisLigacao());
		formulario.setSituacaoLigacao(updatedFormulario.getSituacaoLigacao());
		formulario.setDhLigacao(updatedFormulario.getDhLigacao());
		formulario.setSituacaoConversa(updatedFormulario.getSituacaoConversa());
		formulario.setDhEntrevista(updatedFormulario.getDhEntrevista());
		formulario.setIcComparecimento(updatedFormulario.getIcComparecimento());
		formulario.setSituacaoCandidatura(updatedFormulario.getSituacaoCandidatura());
		formulario.setMotivoCandidatura(updatedFormulario.getMotivoCandidatura());
		formulario.setDtTurma(updatedFormulario.getDtTurma());
		formulario.setTipoEscala(updatedFormulario.getTipoEscala());
		formulario.setHorarioContratacao(updatedFormulario.getHorarioContratacao());
		formulario.setDeDocumentacao(updatedFormulario.getDeDocumentacao());
		formulario.setDeObservacao(updatedFormulario.getDeObservacao());
		formulario.setIcIntegracao(updatedFormulario.getIcIntegracao());
		formulario.setSituacaoCandidato(updatedFormulario.getSituacaoCandidato());

		return formularioRepository.save(formulario);
	}

	@Transactional 
	public Formulario createFormulario(Formulario formulario) { 
		return formularioRepository.save(formulario); 
	}
	
    @Transactional
    public void deleteFormulario(Long id) {
        Formulario formulario = formularioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Formulario not found with id " + id));
        formularioRepository.delete(formulario);
    }

}
