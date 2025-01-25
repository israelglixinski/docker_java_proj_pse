package com.plansul.pse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.SituacaoCandidato;
import com.plansul.pse.repository.SituacaoCandidatoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SituacaoCandidatoService {

    @Autowired
    private SituacaoCandidatoRepository situacaoCandidatoRepository;

    public List<SituacaoCandidato> findAll() {
        return situacaoCandidatoRepository.findAll();
    }

    public Optional<SituacaoCandidato> findById(Long id) {
        return situacaoCandidatoRepository.findById(id);
    }

    public SituacaoCandidato save(SituacaoCandidato situacaoCandidato) {
        return situacaoCandidatoRepository.save(situacaoCandidato);
    }

    public SituacaoCandidato update(Long id, SituacaoCandidato situacaoCandidatoDetails) {
        SituacaoCandidato situacaoCandidato = situacaoCandidatoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException ("SituacaoCandidato not found for this id :: " + id));

        situacaoCandidato.setDeStatusCandidato(situacaoCandidatoDetails.getDeStatusCandidato());
        situacaoCandidato.setStatus(situacaoCandidatoDetails.getStatus());

        final SituacaoCandidato updatedSituacaoCandidato = situacaoCandidatoRepository.save(situacaoCandidato);
        return updatedSituacaoCandidato;
    }

    public void deleteById(Long id) {
        situacaoCandidatoRepository.deleteById(id);
    }
}
