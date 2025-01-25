package com.plansul.pse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plansul.pse.entity.MeioProspeccao;
import com.plansul.pse.entity.MotivoCandidatura;
import com.plansul.pse.entity.SituacaoCandidato;
import com.plansul.pse.entity.SituacaoCandidatura;
import com.plansul.pse.entity.SituacaoConversa;
import com.plansul.pse.entity.SituacaoLigacao;
import com.plansul.pse.entity.TipoEscala;
import com.plansul.pse.service.MeioProspeccaoService;
import com.plansul.pse.service.MotivoCandidaturaService;
import com.plansul.pse.service.SituacaoCandidatoService;
import com.plansul.pse.service.SituacaoCandidaturaService;
import com.plansul.pse.service.SituacaoConversaService;
import com.plansul.pse.service.SituacaoLigacaoService;
import com.plansul.pse.service.TipoEscalaService;

@RestController
@RequestMapping("/parametros")
@PreAuthorize("hasAnyRole('ADMIN')")
public class ParametrosController {
	
	@Autowired
	MeioProspeccaoService meioProspeccaoService;
	
	@Autowired
	MotivoCandidaturaService motivoCandidaturaService;
	
	@Autowired
	SituacaoCandidatoService situacaoCandidatoService;
	
	@Autowired
	SituacaoCandidaturaService situacaoCandidaturaService;
	
	@Autowired
	SituacaoLigacaoService situacaoLigacaoService;

	@Autowired
	SituacaoConversaService situacaoConversa;
	
	@Autowired
	TipoEscalaService tipoEscalaService;
	
	
	
	@GetMapping("/meio_prospeccao")
	public ResponseEntity<List<MeioProspeccao>> getMeioProspeccao(){
		return ResponseEntity.ok(meioProspeccaoService.findAll());
	}

	@GetMapping("/motivo_candidatura")
	public ResponseEntity<List<MotivoCandidatura>> getMotivoCandidatura(){
		return ResponseEntity.ok(motivoCandidaturaService.findAll());
	}
	
	@GetMapping("/situacao_candidato")
	public ResponseEntity<List<SituacaoCandidato>> getSituacaoCandidato(){
		return ResponseEntity.ok(situacaoCandidatoService.findAll());
	}
	
	@GetMapping("/situacao_candidatura")
	public ResponseEntity<List<SituacaoCandidatura>> getSituacaoCandidatura(){
		return ResponseEntity.ok(situacaoCandidaturaService.findAll());
	}
	
	@GetMapping("/situacao_ligacao")
	public ResponseEntity<List<SituacaoLigacao>> getSituacaoLigacao(){
		return ResponseEntity.ok(situacaoLigacaoService.findAll());
	}
	
	@GetMapping("/tipo_escala")
	public ResponseEntity<List<TipoEscala>> getTipoEscala(){
		return ResponseEntity.ok(tipoEscalaService.findAll());
	}
	
	@GetMapping("/situacao_conversa") 
	public ResponseEntity<List<SituacaoConversa>> getSituacaoConversa(){
		return ResponseEntity.ok(situacaoConversa.findAll()); 
	}
	

}
