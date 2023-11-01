package com.cibertec.assistanceapi.repositories;

import com.cibertec.assistanceapi.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findByNameStartingWith(String nom);

}
