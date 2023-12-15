package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.AppointmentDTO;
import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);


    AppointmentDTO appointmentToAppointmentDTO(Appointment appointment);
    Appointment appointmentDTOToAppointment(AppointmentDTO appointmentDTO);
    List<AppointmentDTO> appointmentListToAppointmentDTOList(List<Appointment> appointments);
    List<Appointment> appointmentDTOListToAppointmentList(List<AppointmentDTO> appointmentDTOS);
    AppointmentChildDTO appointmentDTOToAppointmentChildDTO(AppointmentDTO appointmentDTO);
}
