package com.cibertec.assistanceapi.servlets;

import com.cibertec.assistanceapi.entities.Schedule;
import com.cibertec.assistanceapi.services.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/web/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {

        this.scheduleService=scheduleService;

    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {

        try {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(scheduleService.getAll());

        } catch (Exception ex) {

            return ResponseEntity.status((HttpStatus.NOT_FOUND))
                    .body("{\"ERROR\":\"Eror. Por favor intente mas tarde.\"}");

        }

    }
    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody Schedule entidad) {

        try {



            return ResponseEntity.status(HttpStatus.OK)
                    .body(scheduleService.save(entidad));

        } catch(Exception ex) {

            return ResponseEntity.status((HttpStatus.NOT_FOUND))
                    .body("{\"ERROR\":\"Eror. Por favor intente mas tarde.\"}");

        }

    }


}
