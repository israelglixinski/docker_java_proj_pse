package com.plansul.pse.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.SituacaoCandidatura;
import com.plansul.pse.repository.SituacaoCandidaturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SituacaoCandidaturaService {

    @Autowired
    private SituacaoCandidaturaRepository situacaoCandidaturaRepository;

    public List<SituacaoCandidatura> findAll() {
        return situacaoCandidaturaRepository.findAll();
    }

    public Optional<SituacaoCandidatura> findById(Long id) {
        return situacaoCandidaturaRepository.findById(id);
    }

    public SituacaoCandidatura save(SituacaoCandidatura situacaoCandidatura) {
        return situacaoCandidaturaRepository.save(situacaoCandidatura);
    }

    public SituacaoCandidatura update(Long id, SituacaoCandidatura situacaoCandidaturaDetails) {
        SituacaoCandidatura situacaoCandidatura = situacaoCandidaturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SituacaoCandidatura not found for this id :: " + id));

        situacaoCandidatura.setDeStatusCandidatura(situacaoCandidaturaDetails.getDeStatusCandidatura());
        situacaoCandidatura.setStatus(situacaoCandidaturaDetails.getStatus());

        final SituacaoCandidatura updatedSituacaoCandidatura = situacaoCandidaturaRepository.save(situacaoCandidatura);
        return updatedSituacaoCandidatura;
    }

    public void deleteById(Long id) {
        situacaoCandidaturaRepository.deleteById(id);
    }
}
