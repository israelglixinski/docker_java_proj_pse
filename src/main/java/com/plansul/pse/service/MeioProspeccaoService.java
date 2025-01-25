package com.plansul.pse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.plansul.pse.entity.MeioProspeccao;
import com.plansul.pse.repository.MeioProspeccaoRepository;

@Service
public class MeioProspeccaoService {

	@Autowired
	private MeioProspeccaoRepository meioProspeccaoRepository;

	public List<MeioProspeccao> findAll() {
		return meioProspeccaoRepository.findAll();
	}

	public Optional<MeioProspeccao> findById(Long id) {
		return meioProspeccaoRepository.findById(id);
	}

	public MeioProspeccao save(MeioProspeccao meioProspeccao) {
		return meioProspeccaoRepository.save(meioProspeccao);
	}

	public MeioProspeccao update(Long id, MeioProspeccao meioProspeccaoDetails) {
		MeioProspeccao meioProspeccao = meioProspeccaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("MeioProspeccao not found for this id :: " + id));

		meioProspeccao.setDeMeioProspeccao(meioProspeccaoDetails.getDeMeioProspeccao());
		meioProspeccao.setStatus(meioProspeccaoDetails.getStatus());

		final MeioProspeccao updatedMeioProspeccao = meioProspeccaoRepository.save(meioProspeccao);
		return updatedMeioProspeccao;
	}

	public void deleteById(Long id) {
		meioProspeccaoRepository.deleteById(id);
	}
}
