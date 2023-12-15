package com.david.citasMedicas.Controller;

import com.david.citasMedicas.DTO.DoctorDTO;
import com.david.citasMedicas.DTO.PatientDTO;
import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.DTO.childDTO.DoctorChildDTO;
import com.david.citasMedicas.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @GetMapping(path = "/patients/{id}")
    public PatientDTO one(@PathVariable String id) {
        return patientService.findOne(id);
    }

    @GetMapping(path = "/patients")
    public List<PatientDTO> all(){
        return patientService.findAll();
    }

    @PostMapping(path = "/patient")
    public ResponseEntity<Object> add(@RequestBody PatientDTO patientDTO){
        patientService.create(patientDTO);
        return new ResponseEntity<>(patientDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/patient")
    public ResponseEntity<Object> modify(@RequestBody PatientDTO patientDTO){
        patientService.modify(patientDTO);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/patient/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        patientService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(path = "/patient/{patient_id}/doctor/{doctor_id}")
    public ResponseEntity<Object> addDoctor(@PathVariable String patient_id, @PathVariable String doctor_id){
        patientService.addDoctor(patient_id, doctor_id);
        return new ResponseEntity<>(patient_id, HttpStatus.OK);
    }

    @DeleteMapping(path = "/patient/{patient_id}/doctor/{doctor_id}")
    public ResponseEntity<Object> removeDoctor(@PathVariable String patient_id, @PathVariable String doctor_id){
        patientService.removeDoctor(patient_id, doctor_id);
        return new ResponseEntity<>(doctor_id,HttpStatus.OK);
    }
}
