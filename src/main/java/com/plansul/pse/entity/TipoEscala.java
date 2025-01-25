package com.plansul.pse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "apoio", name = "tb_tipo_escala")
@Data
public class TipoEscala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_tipo_escala")
	private Long coTipoEscala;
	
	@Column(name = "no_tipo_escala")
	private String noTipoEscala;
	
	@Column(nullable = false,columnDefinition = "int default 1" )
	private int status;
	

}
