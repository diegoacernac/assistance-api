package com.cibertec.assistanceapi.services;

import com.cibertec.assistanceapi.entities.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    List<Schedule> getAll();

    Optional<Schedule> getById(int id);

    Schedule save(Schedule schedule);

    Schedule update(Integer id,Schedule schedule);

    void deleteById(int id);

}
