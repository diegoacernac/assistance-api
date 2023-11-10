package com.cibertec.assistanceapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ingreso")
    private LocalDate horaingreso;

    @Column(name="salida")
    private LocalDate horasalida;

    @Column(name="fechainicio")
    private Date fechainicio;

    @Column(name="fechafin")
    private Date fechafin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempleado")
    private Employee idempleado;


}
