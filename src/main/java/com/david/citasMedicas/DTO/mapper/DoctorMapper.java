package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.DoctorDTO;
import com.david.citasMedicas.DTO.childDTO.DoctorChildDTO;
import com.david.citasMedicas.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);


    DoctorDTO doctorToDoctorDTO(Doctor doctor);
    Doctor doctorDTOToDoctor(DoctorDTO doctorDTO);
    List<DoctorDTO> doctorListToDoctorDTOList(List<Doctor> doctors);
    List<Doctor> doctorDTOListToDoctorList(List<DoctorDTO> doctorDTOS);
    DoctorChildDTO doctorDTOToDoctorChildDTO(DoctorDTO doctorDTO);

}
