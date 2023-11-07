package com.cibertec.assistanceapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_area")

public class Area {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_area;
	private String description;
	private int state; 
}
