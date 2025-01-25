package com.plansul.pse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "apoio", name = "tb_motivo_candidatura")
@Data
public class MotivoCandidatura {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_motivo_candidatura")
	private Long coMotivoCandidatura;
	
	@Column(name = "de_motivo_candidatura")
	private String deMotivoCandidatura;
	
	@Column(nullable = false,columnDefinition = "int default 1" )
	private int status;
	
	
}
