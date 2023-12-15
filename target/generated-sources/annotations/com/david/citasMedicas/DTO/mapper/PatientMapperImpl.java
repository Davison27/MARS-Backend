package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.PatientDTO;
import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.DTO.childDTO.DoctorChildDTO;
import com.david.citasMedicas.DTO.childDTO.PatientChildDTO;
import com.david.citasMedicas.entity.Appointment;
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
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientDTO patientToPatientDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setName( patient.getName() );
        patientDTO.setPassword( patient.getPassword() );
        patientDTO.setSurnames( patient.getSurnames() );
        patientDTO.setUser( patient.getUser() );
        patientDTO.setAppointments( appointmentListToAppointmentChildDTOList( patient.getAppointments() ) );
        patientDTO.setDirection( patient.getDirection() );
        patientDTO.setDoctors( doctorListToDoctorChildDTOList( patient.getDoctors() ) );
        patientDTO.setNSS( patient.getNSS() );
        patientDTO.setNumCard( patient.getNumCard() );
        patientDTO.setTelephone( patient.getTelephone() );

        return patientDTO;
    }

    @Override
    public Patient patientDTOTOPatient(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setName( patientDTO.getName() );
        patient.setPassword( patientDTO.getPassword() );
        patient.setSurnames( patientDTO.getSurnames() );
        patient.setUser( patientDTO.getUser() );
        patient.setAppointments( appointmentChildDTOListToAppointmentList( patientDTO.getAppointments() ) );
        patient.setDirection( patientDTO.getDirection() );
        patient.setDoctors( doctorChildDTOListToDoctorList( patientDTO.getDoctors() ) );
        patient.setNSS( patientDTO.getNSS() );
        patient.setNumCard( patientDTO.getNumCard() );
        patient.setTelephone( patientDTO.getTelephone() );

        return patient;
    }

    @Override
    public List<PatientDTO> patientListToPatientDTOList(List<Patient> patients) {
        if ( patients == null ) {
            return null;
        }

        List<PatientDTO> list = new ArrayList<PatientDTO>( patients.size() );
        for ( Patient patient : patients ) {
            list.add( patientToPatientDTO( patient ) );
        }

        return list;
    }

    @Override
    public List<Patient> patientDTOListToPatientList(List<PatientDTO> patientDTOS) {
        if ( patientDTOS == null ) {
            return null;
        }

        List<Patient> list = new ArrayList<Patient>( patientDTOS.size() );
        for ( PatientDTO patientDTO : patientDTOS ) {
            list.add( patientDTOTOPatient( patientDTO ) );
        }

        return list;
    }

    @Override
    public PatientChildDTO patientDTOToPatientChildDTO(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        PatientChildDTO patientChildDTO = new PatientChildDTO();

        patientChildDTO.setName( patientDTO.getName() );
        patientChildDTO.setPassword( patientDTO.getPassword() );
        patientChildDTO.setSurnames( patientDTO.getSurnames() );
        patientChildDTO.setUser( patientDTO.getUser() );
        patientChildDTO.setDirection( patientDTO.getDirection() );
        patientChildDTO.setNSS( patientDTO.getNSS() );
        patientChildDTO.setNumCard( patientDTO.getNumCard() );
        patientChildDTO.setTelephone( patientDTO.getTelephone() );

        return patientChildDTO;
    }

    protected AppointmentChildDTO appointmentToAppointmentChildDTO(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentChildDTO appointmentChildDTO = new AppointmentChildDTO();

        appointmentChildDTO.setAttribute11( appointment.getAttribute11() );
        appointmentChildDTO.setDateHour( appointment.getDateHour() );
        appointmentChildDTO.setId( appointment.getId() );
        appointmentChildDTO.setReason( appointment.getReason() );

        return appointmentChildDTO;
    }

    protected List<AppointmentChildDTO> appointmentListToAppointmentChildDTOList(List<Appointment> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentChildDTO> list1 = new ArrayList<AppointmentChildDTO>( list.size() );
        for ( Appointment appointment : list ) {
            list1.add( appointmentToAppointmentChildDTO( appointment ) );
        }

        return list1;
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

    protected List<DoctorChildDTO> doctorListToDoctorChildDTOList(List<Doctor> list) {
        if ( list == null ) {
            return null;
        }

        List<DoctorChildDTO> list1 = new ArrayList<DoctorChildDTO>( list.size() );
        for ( Doctor doctor : list ) {
            list1.add( doctorToDoctorChildDTO( doctor ) );
        }

        return list1;
    }

    protected Appointment appointmentChildDTOToAppointment(AppointmentChildDTO appointmentChildDTO) {
        if ( appointmentChildDTO == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setAttribute11( appointmentChildDTO.getAttribute11() );
        appointment.setDateHour( appointmentChildDTO.getDateHour() );
        appointment.setId( appointmentChildDTO.getId() );
        appointment.setReason( appointmentChildDTO.getReason() );

        return appointment;
    }

    protected List<Appointment> appointmentChildDTOListToAppointmentList(List<AppointmentChildDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Appointment> list1 = new ArrayList<Appointment>( list.size() );
        for ( AppointmentChildDTO appointmentChildDTO : list ) {
            list1.add( appointmentChildDTOToAppointment( appointmentChildDTO ) );
        }

        return list1;
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

    protected List<Doctor> doctorChildDTOListToDoctorList(List<DoctorChildDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Doctor> list1 = new ArrayList<Doctor>( list.size() );
        for ( DoctorChildDTO doctorChildDTO : list ) {
            list1.add( doctorChildDTOToDoctor( doctorChildDTO ) );
        }

        return list1;
    }
}
