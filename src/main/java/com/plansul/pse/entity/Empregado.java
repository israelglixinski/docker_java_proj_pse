package com.plansul.pse.entity;

import java.sql.Time;
import java.sql.Timestamp;

import org.hibernate.annotations.View;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema= "APOIO",name= "VW_EMPREGADOS")
@Getter
@Setter
public class Empregado {
	@Id
	@Column(name = "de_matricula")
	private Long deMatricula;
	
	private String login;
	private String nome;
	
	@Column(name = "nu_cpf")
	private String nuCpf;
	@Column(name = "co_filial")
	private int coFilial;
	@Column(name = "co_funcao")
	private int coFuncao;
	@Column(name = "dtnascimento")
	private Timestamp dtNascimento;
	@Column(name = "dt_admicao")
	private Timestamp dtAdmicao;
	@Column(name = "dt_demicao")
	private Timestamp dtDemicao;
	@Column(name = "id_situacao")
	private int idSituacao;
	@Column(name = "dt_situacao")
	private Timestamp dtSituacao;
	@Column(name = "jorn_ent")
	private Time jornEnt;
	@Column(name = "jorn_sai")
	private Time jornSai;
	@Column(name = "mat_gestor")
	private String matGestor;
	@Column(name = "nu_telefone1")
	private String nuTelefone1;
	@Column(name = "nu_telefone2")
	private String nuTelefone2;
	@Column(name = "nome_social")
	private String nomeSocial;
	
	private String sexo;
	@Column(name = "de_situacao")
	private String deSituacao;
	
}
