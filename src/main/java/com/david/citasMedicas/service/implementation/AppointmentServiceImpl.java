package com.david.citasMedicas.service.implementation;

import com.david.citasMedicas.DTO.AppointmentDTO;
import com.david.citasMedicas.DTO.DoctorDTO;
import com.david.citasMedicas.DTO.PatientDTO;
import com.david.citasMedicas.DTO.childDTO.DoctorChildDTO;
import com.david.citasMedicas.DTO.childDTO.PatientChildDTO;
import com.david.citasMedicas.DTO.mapper.AppointmentMapper;
import com.david.citasMedicas.DTO.mapper.DiagnosisMapper;
import com.david.citasMedicas.entity.Appointment;
import com.david.citasMedicas.entity.Doctor;
import com.david.citasMedicas.entity.Patient;
import com.david.citasMedicas.exception.Exceptions;
import com.david.citasMedicas.exception.enums.ResultEnum;
import com.david.citasMedicas.repository.AppointmentRepository;
import com.david.citasMedicas.repository.DiagnosisRepository;
import com.david.citasMedicas.service.AppointmentService;
import com.david.citasMedicas.service.DoctorService;
import com.david.citasMedicas.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final DiagnosisRepository diagnosisRepository;

    private final PatientService patientService;

    private final DoctorService doctorService;

    private final DiagnosisMapper diagnosisMapper = DiagnosisMapper.INSTANCE;

    private final AppointmentMapper appointmentMapper = AppointmentMapper.INSTANCE;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientService patientService, DoctorService doctorService, DiagnosisRepository diagnosisRepository){
        this.appointmentRepository=appointmentRepository;
        this.patientService=patientService;
        this.doctorService=doctorService;
        this.diagnosisRepository=diagnosisRepository;
    }

    @Override
    public AppointmentDTO findOne(String id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment == null) throw new Exceptions(ResultEnum.APPOINTMENT_NOT_EXIST);
        return appointmentMapper.appointmentToAppointmentDTO(appointment);
    }

    @Override
    public List<AppointmentDTO> findAll() {
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        return appointmentMapper.appointmentListToAppointmentDTOList(appointments);
    }

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        String id = appointmentDTO.getId();
        if(id != null) throw new Exceptions(ResultEnum.APPOINTMENT_EXIST);

        PatientDTO patient = patientService.findOne(appointmentDTO.getPatient().getUser());
        DoctorDTO doctor = doctorService.findOne(appointmentDTO.getDoctor().getUser());

        patient.getAppointments().add(appointmentMapper.appointmentDTOToAppointmentChildDTO(appointmentDTO));
        doctor.getAppointments().add(appointmentMapper.appointmentDTOToAppointmentChildDTO(appointmentDTO));

        patientService.modify(patient);
        doctorService.modify(doctor);

        return appointmentMapper.appointmentToAppointmentDTO(appointmentRepository.findById(id).orElse(null));
    }

    @Override
    public AppointmentDTO modify(AppointmentDTO appointmentDTO) {
        String id = appointmentDTO.getId();
        if(id == null) throw new Exceptions(ResultEnum.APPOINTMENT_NOT_EXIST);

        PatientDTO patient = patientService.findOne(appointmentDTO.getPatient().getUser());
        DoctorDTO doctor = doctorService.findOne(appointmentDTO.getDoctor().getUser());

        patient.getAppointments().add(appointmentMapper.appointmentDTOToAppointmentChildDTO(appointmentDTO));
        doctor.getAppointments().add(appointmentMapper.appointmentDTOToAppointmentChildDTO(appointmentDTO));

        patientService.modify(patient);
        doctorService.modify(doctor);

        return appointmentMapper.appointmentToAppointmentDTO(appointmentRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(String id) {
        AppointmentDTO appointmentDTO = findOne(id);
        if(appointmentDTO == null) throw new Exceptions(ResultEnum.APPOINTMENT_NOT_EXIST);
        if(appointmentDTO.getDiagnosis() != null) diagnosisRepository.delete(diagnosisMapper.diagnosisDTOToDiagnosis(appointmentDTO.getDiagnosis()));
        appointmentRepository.delete(appointmentMapper.appointmentDTOToAppointment(appointmentDTO));

    }

    @Override
    public List<AppointmentDTO> patientAppointments(String id) {
        //TODO
        return null;
    }

    @Override
    public List<AppointmentDTO> doctorAppointments(String id) {
        //TODO
        return null;
    }
}
