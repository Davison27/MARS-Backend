package com.david.citasMedicas.Controller;

import com.david.citasMedicas.DTO.DoctorDTO;
import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.DTO.childDTO.PatientChildDTO;
import com.david.citasMedicas.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    @GetMapping(path = "/doctors/{id}")
    public DoctorDTO one(@PathVariable String id) {
        return doctorService.findOne(id);
    }

    @GetMapping(path = "/doctors")
    public List<DoctorDTO> all() { return doctorService.findAll(); }

    @PostMapping(path = "/doctor")
    public ResponseEntity<Object> add(@RequestBody DoctorDTO doctorDTO){
        doctorService.create(doctorDTO);
        return new ResponseEntity<>(doctorDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/doctor")
    public ResponseEntity<Object> modify(@RequestBody DoctorDTO doctorDTO){
        doctorService.modify(doctorDTO);
        return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/doctor/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        doctorService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(path = "/doctor/{doctor_id}/patient/{patient_id}")
    public ResponseEntity<Object> addPatient(@PathVariable String doctor_id, @PathVariable String patient_id){
        doctorService.addPatient(doctor_id, patient_id);
        return new ResponseEntity<>(patient_id, HttpStatus.OK);
    }

    @DeleteMapping(path = "/doctor/{doctor_id}/patient/{patient_id}")
    public ResponseEntity<Object> removePatient(@PathVariable String doctor_id, @PathVariable String patient_id){
        doctorService.removePatient(doctor_id, patient_id);
        return new ResponseEntity<>(patient_id, HttpStatus.OK);
    }

}
