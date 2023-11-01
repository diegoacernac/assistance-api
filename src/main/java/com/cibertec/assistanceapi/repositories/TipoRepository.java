package com.cibertec.assistanceapi.repositories;

import com.cibertec.assistanceapi.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {



}
