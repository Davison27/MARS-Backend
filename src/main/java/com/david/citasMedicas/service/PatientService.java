package com.david.citasMedicas.service;


import com.david.citasMedicas.DTO.PatientDTO;
import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.DTO.childDTO.DoctorChildDTO;

import java.util.List;

public interface PatientService {

    PatientDTO findOne(String user);
    List<PatientDTO> findAll();
    PatientDTO create(PatientDTO patientDTO);
    void modify(PatientDTO patientDTO);
    void delete(String user);
    void addDoctor(String patient, String doctor);
    void removeDoctor(String patient, String doctor);

}
