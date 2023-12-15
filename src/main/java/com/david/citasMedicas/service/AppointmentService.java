package com.david.citasMedicas.service;

import com.david.citasMedicas.DTO.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    AppointmentDTO findOne(String id);
    List<AppointmentDTO> findAll();
    AppointmentDTO create(AppointmentDTO appointmentDTO);
    AppointmentDTO modify(AppointmentDTO appointmentDTO);
    void delete(String id);
    List<AppointmentDTO> patientAppointments(String id);
    List<AppointmentDTO> doctorAppointments(String id);
}
