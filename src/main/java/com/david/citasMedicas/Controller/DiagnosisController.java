package com.david.citasMedicas.Controller;

import com.david.citasMedicas.DTO.DiagnosisDTO;
import com.david.citasMedicas.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService){
        this.diagnosisService=diagnosisService;
    }

    @GetMapping(path = "/diagnosis/{id}")
    public DiagnosisDTO one(@PathVariable String id){ return diagnosisService.findOne(id); }

    @GetMapping(path = "/diagnosis")
    public List<DiagnosisDTO> all(){ return diagnosisService.findAll(); }

    @PostMapping(path = "/diagnosis")
    public ResponseEntity<Object> add(@RequestBody DiagnosisDTO diagnosisDTO){
        diagnosisService.create(diagnosisDTO);
        return new ResponseEntity<>(diagnosisDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/diagnosis/{id}")
    public ResponseEntity<Object> modify(@RequestBody DiagnosisDTO diagnosisDTO){
        diagnosisService.modify(diagnosisDTO);
        return new ResponseEntity<>(diagnosisDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/diagnosis/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        diagnosisService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
