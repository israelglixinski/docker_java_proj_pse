package com.plansul.pse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.MotivoCandidatura;
import com.plansul.pse.repository.MotivoCandidaturaRepository;

@Service
public class MotivoCandidaturaService {

	@Autowired
	private MotivoCandidaturaRepository motivoCandidaturaRepository;

	public List<MotivoCandidatura> findAll() {
		return motivoCandidaturaRepository.findAll();
	}

	public Optional<MotivoCandidatura> findById(Long id) {
		return motivoCandidaturaRepository.findById(id);
	}

	public MotivoCandidatura save(MotivoCandidatura motivoCandidatura) {
		return motivoCandidaturaRepository.save(motivoCandidatura);
	}

	public MotivoCandidatura update(Long id, MotivoCandidatura motivoCandidaturaDetails) {
		MotivoCandidatura motivoCandidatura = motivoCandidaturaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("MotivoCandidatura not found for this id :: " + id));

		motivoCandidatura.setDeMotivoCandidatura(motivoCandidaturaDetails.getDeMotivoCandidatura());
		motivoCandidatura.setStatus(motivoCandidaturaDetails.getStatus());

		final MotivoCandidatura updatedMotivoCandidatura = motivoCandidaturaRepository.save(motivoCandidatura);
		return updatedMotivoCandidatura;
	}

	public void deleteById(Long id) {
		motivoCandidaturaRepository.deleteById(id);
	}
}
