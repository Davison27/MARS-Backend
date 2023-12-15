package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.DoctorDTO;
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
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorDTO doctorToDoctorDTO(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setName( doctor.getName() );
        doctorDTO.setPassword( doctor.getPassword() );
        doctorDTO.setSurnames( doctor.getSurnames() );
        doctorDTO.setUser( doctor.getUser() );
        doctorDTO.setAppointments( appointmentListToAppointmentChildDTOList( doctor.getAppointments() ) );
        doctorDTO.setMembershipNum( doctor.getMembershipNum() );
        doctorDTO.setPatients( patientListToPatientChildDTOList( doctor.getPatients() ) );

        return doctorDTO;
    }

    @Override
    public Doctor doctorDTOToDoctor(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setName( doctorDTO.getName() );
        doctor.setPassword( doctorDTO.getPassword() );
        doctor.setSurnames( doctorDTO.getSurnames() );
        doctor.setUser( doctorDTO.getUser() );
        doctor.setAppointments( appointmentChildDTOListToAppointmentList( doctorDTO.getAppointments() ) );
        doctor.setMembershipNum( doctorDTO.getMembershipNum() );
        doctor.setPatients( patientChildDTOListToPatientList( doctorDTO.getPatients() ) );

        return doctor;
    }

    @Override
    public List<DoctorDTO> doctorListToDoctorDTOList(List<Doctor> doctors) {
        if ( doctors == null ) {
            return null;
        }

        List<DoctorDTO> list = new ArrayList<DoctorDTO>( doctors.size() );
        for ( Doctor doctor : doctors ) {
            list.add( doctorToDoctorDTO( doctor ) );
        }

        return list;
    }

    @Override
    public List<Doctor> doctorDTOListToDoctorList(List<DoctorDTO> doctorDTOS) {
        if ( doctorDTOS == null ) {
            return null;
        }

        List<Doctor> list = new ArrayList<Doctor>( doctorDTOS.size() );
        for ( DoctorDTO doctorDTO : doctorDTOS ) {
            list.add( doctorDTOToDoctor( doctorDTO ) );
        }

        return list;
    }

    @Override
    public DoctorChildDTO doctorDTOToDoctorChildDTO(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        DoctorChildDTO doctorChildDTO = new DoctorChildDTO();

        doctorChildDTO.setName( doctorDTO.getName() );
        doctorChildDTO.setPassword( doctorDTO.getPassword() );
        doctorChildDTO.setSurnames( doctorDTO.getSurnames() );
        doctorChildDTO.setUser( doctorDTO.getUser() );
        doctorChildDTO.setMembershipNum( doctorDTO.getMembershipNum() );

        return doctorChildDTO;
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

    protected List<PatientChildDTO> patientListToPatientChildDTOList(List<Patient> list) {
        if ( list == null ) {
            return null;
        }

        List<PatientChildDTO> list1 = new ArrayList<PatientChildDTO>( list.size() );
        for ( Patient patient : list ) {
            list1.add( patientToPatientChildDTO( patient ) );
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

    protected List<Patient> patientChildDTOListToPatientList(List<PatientChildDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Patient> list1 = new ArrayList<Patient>( list.size() );
        for ( PatientChildDTO patientChildDTO : list ) {
            list1.add( patientChildDTOToPatient( patientChildDTO ) );
        }

        return list1;
    }
}
