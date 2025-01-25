package com.plansul.pse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "apoio", name = "tb_meio_prospeccao")
@Data
public class MeioProspeccao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_meio_prospeccao")
	private Long coMeioProspeccao;
	
	@Column(name = "de_meio_prospeccao")
	private String deMeioProspeccao;
	
	@Column(name = "ic_pago", nullable = false,columnDefinition = "int default 0" )
	private int icPago;
	
	@Column(nullable = false,columnDefinition = "int default 1" )
	private int status;
	
	

}
