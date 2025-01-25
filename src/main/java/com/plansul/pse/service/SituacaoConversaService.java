package com.plansul.pse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.SituacaoConversa;
import com.plansul.pse.repository.SituacaoConversaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SituacaoConversaService {

    @Autowired
    private SituacaoConversaRepository situacaoConversaRepository;

    public List<SituacaoConversa> findAll() {
        return situacaoConversaRepository.findAll();
    }

    public Optional<SituacaoConversa> findById(Long id) {
        return situacaoConversaRepository.findById(id);
    }

    public SituacaoConversa save(SituacaoConversa situacaoConversa) {
        return situacaoConversaRepository.save(situacaoConversa);
    }

    public SituacaoConversa update(Long id, SituacaoConversa situacaoConversaDetails) {
        SituacaoConversa situacaoConversa = situacaoConversaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SituacaoConversa not found for this id :: " + id));

        situacaoConversa.setDeStatusConversa(situacaoConversaDetails.getDeStatusConversa());
        situacaoConversa.setStatus(situacaoConversaDetails.getStatus());

        final SituacaoConversa updatedSituacaoConversa = situacaoConversaRepository.save(situacaoConversa);
        return updatedSituacaoConversa;
    }

    public void deleteById(Long id) {
        situacaoConversaRepository.deleteById(id);
    }
}
