package com.cibertec.assistanceapi.services;

import com.cibertec.assistanceapi.entities.Schedule;
import com.cibertec.assistanceapi.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;


    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule save(Schedule schedule) {
        // Puedes realizar validaciones antes de guardar, si es necesario
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule update(Integer id, Schedule schedule) {
        // Verificar si la entidad ya existe
        Optional<Schedule> existingSchedule = scheduleRepository.findById(id);

        if (existingSchedule.isPresent()) {
            // Actualizar solo si la entidad ya existe
            return scheduleRepository.save(schedule);
        } else {

            System.out.println("Error: no existe el usuario");
            return  null;

        }
    }

    @Override
    public void deleteById(int id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Optional<Schedule> getById(int id) {
        return scheduleRepository.findById(id);
    }

}
