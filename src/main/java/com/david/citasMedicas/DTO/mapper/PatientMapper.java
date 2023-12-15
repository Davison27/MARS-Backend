package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.PatientDTO;
import com.david.citasMedicas.DTO.childDTO.PatientChildDTO;
import com.david.citasMedicas.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDTO patientToPatientDTO(Patient patient);
    Patient patientDTOTOPatient(PatientDTO patientDTO);
    List<PatientDTO> patientListToPatientDTOList(List<Patient> patients);
    List<Patient> patientDTOListToPatientList(List<PatientDTO> patientDTOS);
    PatientChildDTO patientDTOToPatientChildDTO(PatientDTO patientDTO);
}
