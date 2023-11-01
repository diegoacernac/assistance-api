package com.cibertec.assistanceapi.repositories;

import com.cibertec.assistanceapi.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {



}
