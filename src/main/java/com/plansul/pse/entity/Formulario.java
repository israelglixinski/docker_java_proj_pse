package com.plansul.pse.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "cadastro" ,name = "tb_formulario")
@Getter
@Setter
public class Formulario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_formulario")
	private Long coFormulario;
	
	@OneToMany
	private List<Empregado> responsaveisLigacao;
	
	@OneToOne
	@JoinColumn(name = "co_status_ligacao")
	private SituacaoLigacao situacaoLigacao;
	
	@Column(name = "dh_ligacao")
	private List<Timestamp> dhLigacao;
	
	@ManyToOne
	@JoinColumn(name = "co_status_conversa")
	private SituacaoConversa situacaoConversa;
	
//	=====================================================
	
	@Column(name = "dh_entrevista")
	private Timestamp dhEntrevista;
	
	@Column(name = "ic_comparecimento")
	private int icComparecimento;
	
	@ManyToOne
	@JoinColumn(name = "co_status_candidatura")
	private SituacaoCandidatura situacaoCandidatura;
	

	@ManyToOne
	@JoinColumn(name = "co_motivo_candidatura")
	private MotivoCandidatura motivoCandidatura;
	
	@Column(name = "dt_turma")
	private Date dtTurma;
	
	@ManyToOne
	@JoinColumn(name = "co_tipo_escala")
	private TipoEscala tipoEscala;
	
	@Column(name = "de_horario_contratacao")
	private String horarioContratacao;
	
	@Column(name = "de_documentacao")
	private String deDocumentacao;
	
	@Column(name = "de_observacao")
	private String deObservacao;
	
	@Column(name = "ic_integracao")
	private int icIntegracao;
	
	@ManyToOne
	@JoinColumn(name = "co_status_candidato")
	private SituacaoCandidato situacaoCandidato; 
	
	
	
	
}
