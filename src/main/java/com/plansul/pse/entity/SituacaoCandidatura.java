package com.plansul.pse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "apoio", name = "tb_status_candidatura")
@Data
public class SituacaoCandidatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_status_candidatura")
	private Long coStatusCandidatura;
	
	@Column(name = "de_status_candidatura")
	private String deStatusCandidatura;
	
	@Column(nullable = false,columnDefinition = "int default 1" )
	private int status;
	
}
