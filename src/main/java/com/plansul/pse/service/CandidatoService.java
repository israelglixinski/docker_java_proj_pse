package com.plansul.pse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.Candidato;
import com.plansul.pse.repository.CandidatoRepository;

import jakarta.transaction.Transactional;

@Service
public class CandidatoService {
	
	@Autowired
	CandidatoRepository candidatoRepository;
	
	public ResponseEntity<Candidato> createCandidato(Candidato candidato){		
		return new ResponseEntity<Candidato>(
				candidatoRepository.save(candidato)
				, HttpStatus.CREATED
			);
	}
	
	public ResponseEntity<List<Candidato>> findAllCandidatos(){
		
		return new ResponseEntity<List<Candidato>>(
				candidatoRepository.findAll()
				, HttpStatus.OK
			);
	}
	
	
	public ResponseEntity<Candidato> findCandidato(Long coCandidato){
		
		Optional<Candidato> candidato = candidatoRepository.findById(coCandidato);
		
		if(candidato.isPresent()) {
			return new ResponseEntity<Candidato>(
					candidato.get()
					, HttpStatus.OK
					);
		}else {
			return new ResponseEntity<Candidato>(HttpStatus.NO_CONTENT);
		}
	}
	


    @Transactional
    public Candidato updateCandidato(Long id, Candidato updatedCandidato) {
        Candidato candidato = candidatoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidato not found with id " + id));

        candidato.setEmpregadoReceptor(updatedCandidato.getEmpregadoReceptor());
        candidato.setDtContato(updatedCandidato.getDtContato());
        candidato.setDeTelefone(updatedCandidato.getDeTelefone());
        candidato.setDeEmail(updatedCandidato.getDeEmail());
        candidato.setNome(updatedCandidato.getNome());
        candidato.setMeioProspeccao(updatedCandidato.getMeioProspeccao());
        candidato.setIcPcd(updatedCandidato.getIcPcd());
        
        candidato.setFormularioCandidatura(updatedCandidato.getFormularioCandidatura());

        return candidatoRepository.save(candidato);
    }
    

    @Transactional
    public void deleteCandidato(Long id) {
        Candidato candidato = candidatoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidato not found with id " + id));
        candidatoRepository.delete(candidato);
    }
	
}
