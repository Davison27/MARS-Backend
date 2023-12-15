package com.david.citasMedicas.service;

import com.david.citasMedicas.DTO.DoctorDTO;
import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.DTO.childDTO.PatientChildDTO;
import com.david.citasMedicas.exception.Exceptions;

import java.util.List;

public interface DoctorService {

    DoctorDTO findOne(String user);
    List<DoctorDTO> findAll();
    DoctorDTO create(DoctorDTO doctorDTO);
    void modify(DoctorDTO doctorDTO);
    void delete(String user);
    void addPatient(String doctor, String patient);
    void removePatient(String doctor, String patient);
}
