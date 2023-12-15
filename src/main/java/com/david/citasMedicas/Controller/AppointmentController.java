package com.david.citasMedicas.Controller;

import com.david.citasMedicas.DTO.AppointmentDTO;
import com.david.citasMedicas.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService=appointmentService;
    }

    @GetMapping(path = "/appointment/{id}")
    public AppointmentDTO one(@PathVariable String id){ return appointmentService.findOne(id); }

    @GetMapping(path = "/appointments")
    public List<AppointmentDTO> all(){ return appointmentService.findAll(); }

    @PostMapping(path = "/appointment")
    public ResponseEntity<Object> add(@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.create(appointmentDTO);
        return new ResponseEntity<>(appointmentDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/appointment")
    public ResponseEntity<Object> modify(@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.modify(appointmentDTO);
        return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/appointment/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        appointmentService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(path = "/appointment/patient/{id}")
    public ResponseEntity<Object> patientAppointment(@PathVariable String id){
        appointmentService.patientAppointments(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(path = "/appointment/doctor/{id}")
    public ResponseEntity<Object> doctorAppointment(@PathVariable String id){
        appointmentService.doctorAppointments(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
