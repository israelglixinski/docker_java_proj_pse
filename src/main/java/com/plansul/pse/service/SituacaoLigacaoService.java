package com.plansul.pse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.SituacaoLigacao;
import com.plansul.pse.repository.SituacaoLigacaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SituacaoLigacaoService {

    @Autowired
    private SituacaoLigacaoRepository situacaoLigacaoRepository;

    public List<SituacaoLigacao> findAll() {
        return situacaoLigacaoRepository.findAll();
    }

    public Optional<SituacaoLigacao> findById(Long id) {
        return situacaoLigacaoRepository.findById(id);
    }

    public SituacaoLigacao save(SituacaoLigacao situacaoLigacao) {
        return situacaoLigacaoRepository.save(situacaoLigacao);
    }

    public SituacaoLigacao update(Long id, SituacaoLigacao situacaoLigacaoDetails) {
        SituacaoLigacao situacaoLigacao = situacaoLigacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SituacaoLigacao not found for this id :: " + id));

        situacaoLigacao.setDeStatusLigacao(situacaoLigacaoDetails.getDeStatusLigacao());
        situacaoLigacao.setStatus(situacaoLigacaoDetails.getStatus());

        final SituacaoLigacao updatedSituacaoLigacao = situacaoLigacaoRepository.save(situacaoLigacao);
        return updatedSituacaoLigacao;
    }

    public void deleteById(Long id) {
        situacaoLigacaoRepository.deleteById(id);
    }
}
