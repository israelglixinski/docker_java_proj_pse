package com.plansul.pse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.TipoEscala;
import com.plansul.pse.repository.TipoEscalaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEscalaService {

    @Autowired
    private TipoEscalaRepository tipoEscalaRepository;

    public List<TipoEscala> findAll() {
        return tipoEscalaRepository.findAll();
    }

    public Optional<TipoEscala> findById(Long id) {
        return tipoEscalaRepository.findById(id);
    }

    public TipoEscala save(TipoEscala tipoEscala) {
        return tipoEscalaRepository.save(tipoEscala);
    }

    public TipoEscala update(Long id, TipoEscala tipoEscalaDetails) {
        TipoEscala tipoEscala = tipoEscalaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoEscala not found for this id :: " + id));

        tipoEscala.setNoTipoEscala(tipoEscalaDetails.getNoTipoEscala());
        tipoEscala.setStatus(tipoEscalaDetails.getStatus());

        final TipoEscala updatedTipoEscala = tipoEscalaRepository.save(tipoEscala);
        return updatedTipoEscala;
    }

    public void deleteById(Long id) {
        tipoEscalaRepository.deleteById(id);
    }
}
