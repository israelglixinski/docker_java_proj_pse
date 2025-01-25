package com.plansul.pse.entity;

import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "cadastro", name = "tb_candidato")
@Getter
@Setter
public class Candidato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_candidato")
	private Long coCandidato;
	
	@ManyToOne
	@JoinColumn(name = "de_matricula_empregado")
	private Empregado empregadoReceptor;
	
	@Column(name = "dt_contato")
	private Timestamp dtContato;
	
	@Column(name = "de_telefone")
	private String deTelefone;
	@Column(name = "de_email")
	private String deEmail;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "co_meio_prospeccao")
	private MeioProspeccao meioProspeccao;
	
	@Column(name = "ic_pcd")
	private int icPcd;
	
	
	@OneToOne
	@JoinColumn(name = "co_formulario_candidatura")
	private Formulario formularioCandidatura;
	
	
}
