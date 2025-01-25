package com.plansul.pse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(schema = "APOIO", name = "VW_USUARIO_CP")
@Getter
public class UserCP {

	@Id
	@Column(name = "de_matricula")
	private Long deMatricula;
	
	private String password;
}
