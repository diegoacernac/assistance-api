package com.cibertec.assistanceapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id;

    @Column(name = "nombre_emp")
    private String name;

    @Column(name = "apellido_emp")
    private String lastname;

    @Column(name = "fechanac_emp")
    private LocalDate dateNac;

    @Column(name = "dni_emp")
    private String dni;

    @Column(name = "correo_emp")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area codArea;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo codType;

    @Column(name = "tarifa_hora_emp")
    private Double salary;

    @Column(name = "estado_emp")
    private int status;

    @Column(name = "fechaRegistro")
    private LocalDate dateReg;

    @Column(name = "nomUsuarioReg")
    private String userReg;

    @Column(name = "fechaActualiza")
    private LocalDate dateUpdate;

    @Column(name = "nomUsuarioAct")
    private String userUpdate;

}
