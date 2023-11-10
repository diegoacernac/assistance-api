package com.cibertec.assistanceapi.repositories;

import com.cibertec.assistanceapi.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {
}
