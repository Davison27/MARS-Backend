package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.AppointmentDTO;
import com.david.citasMedicas.DTO.DiagnosisDTO;
import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.DTO.childDTO.DoctorChildDTO;
import com.david.citasMedicas.DTO.childDTO.PatientChildDTO;
import com.david.citasMedicas.entity.Appointment;
import com.david.citasMedicas.entity.Diagnosis;
import com.david.citasMedicas.entity.Doctor;
import com.david.citasMedicas.entity.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-11T12:56:09+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentDTO appointmentToAppointmentDTO(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setAttribute11( appointment.getAttribute11() );
        appointmentDTO.setDateHour( appointment.getDateHour() );
        appointmentDTO.setDiagnosis( diagnosisToDiagnosisDTO( appointment.getDiagnosis() ) );
        appointmentDTO.setDoctor( doctorToDoctorChildDTO( appointment.getDoctor() ) );
        appointmentDTO.setId( appointment.getId() );
        appointmentDTO.setPatient( patientToPatientChildDTO( appointment.getPatient() ) );
        appointmentDTO.setReason( appointment.getReason() );

        return appointmentDTO;
    }

    @Override
    public Appointment appointmentDTOToAppointment(AppointmentDTO appointmentDTO) {
        if ( appointmentDTO == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setAttribute11( appointmentDTO.getAttribute11() );
        appointment.setDateHour( appointmentDTO.getDateHour() );
        appointment.setDiagnosis( diagnosisDTOToDiagnosis( appointmentDTO.getDiagnosis() ) );
        appointment.setDoctor( doctorChildDTOToDoctor( appointmentDTO.getDoctor() ) );
        appointment.setId( appointmentDTO.getId() );
        appointment.setPatient( patientChildDTOToPatient( appointmentDTO.getPatient() ) );
        appointment.setReason( appointmentDTO.getReason() );

        return appointment;
    }

    @Override
    public List<AppointmentDTO> appointmentListToAppointmentDTOList(List<Appointment> appointments) {
        if ( appointments == null ) {
            return null;
        }

        List<AppointmentDTO> list = new ArrayList<AppointmentDTO>( appointments.size() );
        for ( Appointment appointment : appointments ) {
            list.add( appointmentToAppointmentDTO( appointment ) );
        }

        return list;
    }

    @Override
    public List<Appointment> appointmentDTOListToAppointmentList(List<AppointmentDTO> appointmentDTOS) {
        if ( appointmentDTOS == null ) {
            return null;
        }

        List<Appointment> list = new ArrayList<Appointment>( appointmentDTOS.size() );
        for ( AppointmentDTO appointmentDTO : appointmentDTOS ) {
            list.add( appointmentDTOToAppointment( appointmentDTO ) );
        }

        return list;
    }

    @Override
    public AppointmentChildDTO appointmentDTOToAppointmentChildDTO(AppointmentDTO appointmentDTO) {
        if ( appointmentDTO == null ) {
            return null;
        }

        AppointmentChildDTO appointmentChildDTO = new AppointmentChildDTO();

        appointmentChildDTO.setAttribute11( appointmentDTO.getAttribute11() );
        appointmentChildDTO.setDateHour( appointmentDTO.getDateHour() );
        appointmentChildDTO.setId( appointmentDTO.getId() );
        appointmentChildDTO.setReason( appointmentDTO.getReason() );

        return appointmentChildDTO;
    }

    protected DiagnosisDTO diagnosisToDiagnosisDTO(Diagnosis diagnosis) {
        if ( diagnosis == null ) {
            return null;
        }

        DiagnosisDTO diagnosisDTO = new DiagnosisDTO();

        diagnosisDTO.setDisease( diagnosis.getDisease() );
        diagnosisDTO.setId( diagnosis.getId() );
        diagnosisDTO.setSpecialistAssessment( diagnosis.getSpecialistAssessment() );

        return diagnosisDTO;
    }

    protected DoctorChildDTO doctorToDoctorChildDTO(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorChildDTO doctorChildDTO = new DoctorChildDTO();

        doctorChildDTO.setName( doctor.getName() );
        doctorChildDTO.setPassword( doctor.getPassword() );
        doctorChildDTO.setSurnames( doctor.getSurnames() );
        doctorChildDTO.setUser( doctor.getUser() );
        doctorChildDTO.setMembershipNum( doctor.getMembershipNum() );

        return doctorChildDTO;
    }

    protected PatientChildDTO patientToPatientChildDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientChildDTO patientChildDTO = new PatientChildDTO();

        patientChildDTO.setName( patient.getName() );
        patientChildDTO.setPassword( patient.getPassword() );
        patientChildDTO.setSurnames( patient.getSurnames() );
        patientChildDTO.setUser( patient.getUser() );
        patientChildDTO.setDirection( patient.getDirection() );
        patientChildDTO.setNSS( patient.getNSS() );
        patientChildDTO.setNumCard( patient.getNumCard() );
        patientChildDTO.setTelephone( patient.getTelephone() );

        return patientChildDTO;
    }

    protected Diagnosis diagnosisDTOToDiagnosis(DiagnosisDTO diagnosisDTO) {
        if ( diagnosisDTO == null ) {
            return null;
        }

        Diagnosis diagnosis = new Diagnosis();

        diagnosis.setDisease( diagnosisDTO.getDisease() );
        diagnosis.setId( diagnosisDTO.getId() );
        diagnosis.setSpecialistAssessment( diagnosisDTO.getSpecialistAssessment() );

        return diagnosis;
    }

    protected Doctor doctorChildDTOToDoctor(DoctorChildDTO doctorChildDTO) {
        if ( doctorChildDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setName( doctorChildDTO.getName() );
        doctor.setPassword( doctorChildDTO.getPassword() );
        doctor.setSurnames( doctorChildDTO.getSurnames() );
        doctor.setUser( doctorChildDTO.getUser() );
        doctor.setMembershipNum( doctorChildDTO.getMembershipNum() );

        return doctor;
    }

    protected Patient patientChildDTOToPatient(PatientChildDTO patientChildDTO) {
        if ( patientChildDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setName( patientChildDTO.getName() );
        patient.setPassword( patientChildDTO.getPassword() );
        patient.setSurnames( patientChildDTO.getSurnames() );
        patient.setUser( patientChildDTO.getUser() );
        patient.setDirection( patientChildDTO.getDirection() );
        patient.setNSS( patientChildDTO.getNSS() );
        patient.setNumCard( patientChildDTO.getNumCard() );
        patient.setTelephone( patientChildDTO.getTelephone() );

        return patient;
    }
}
