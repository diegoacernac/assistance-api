package com.cibertec.assistanceapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_area")

public class Area {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_area;
    private String description;
    private int state;
}
