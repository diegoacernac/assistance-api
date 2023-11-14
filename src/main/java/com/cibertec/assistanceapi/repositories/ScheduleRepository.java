package com.cibertec.assistanceapi.repositories;

import com.cibertec.assistanceapi.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
