package com.david.citasMedicas.service.implementation;

import com.david.citasMedicas.DTO.DoctorDTO;
import com.david.citasMedicas.DTO.PatientDTO;
import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.DTO.childDTO.DoctorChildDTO;
import com.david.citasMedicas.DTO.mapper.DoctorMapper;
import com.david.citasMedicas.entity.Patient;
import com.david.citasMedicas.exception.Exceptions;
import com.david.citasMedicas.exception.enums.ResultEnum;
import com.david.citasMedicas.repository.DoctorRepository;
import com.david.citasMedicas.repository.PatientRepository;
import com.david.citasMedicas.service.DoctorService;
import com.david.citasMedicas.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.david.citasMedicas.DTO.mapper.PatientMapper;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    private final PatientMapper patientMapper = PatientMapper.INSTANCE;

    private final DoctorMapper doctorMapper = DoctorMapper.INSTANCE;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository){
        this.patientRepository=patientRepository;
        this.doctorRepository=doctorRepository;
    }

    @Override
    public PatientDTO findOne(String user) {
        Patient patient = patientRepository.findById(user).orElse(null);
       /* if(patient == null) throw new Exceptions(ResultEnum.PATIENT_NOT_EXIST);*/
        return patientMapper.patientToPatientDTO(patient);
    }

    @Override
    public List<PatientDTO> findAll() {
        List<Patient> patients = (List<Patient>) patientRepository.findAll();
        return patientMapper.patientListToPatientDTOList(patients);
    }


    @Override
    public PatientDTO create(PatientDTO patientDTO) {
        String user = patientDTO.getUser();
        if(findOne(user) != null) throw new Exceptions(ResultEnum.PATIENT_EXIST);
        patientRepository.save(patientMapper.patientDTOTOPatient(patientDTO));
        return patientDTO;
    }

    @Override
    public void modify(PatientDTO patientDTO) {
        String user = patientDTO.getUser();
        if(findOne(user) == null) throw new Exceptions(ResultEnum.PATIENT_NOT_EXIST);
        patientRepository.save(patientMapper.patientDTOTOPatient(patientDTO));
    }

    @Override
    public void delete(String user) {
        PatientDTO patientDTO = findOne(user);
        if(patientDTO == null) throw new Exceptions(ResultEnum.PATIENT_NOT_EXIST);
        patientRepository.deleteById(user);
    }

    @Override
    public void addDoctor(String patient, String doctor) {
        PatientDTO patientDTO = findOne(patient);
        if(patientDTO == null) throw new Exceptions(ResultEnum.PATIENT_NOT_EXIST);

        DoctorDTO doctorDTO = doctorMapper.doctorToDoctorDTO(doctorRepository.findById(doctor).orElse(null));
        if(doctorDTO == null) throw new Exceptions(ResultEnum.DOCTOR_NOT_EXIST);

        doctorDTO.getPatients().add(patientMapper.patientDTOToPatientChildDTO(patientDTO));
        patientDTO.getDoctors().add(doctorMapper.doctorDTOToDoctorChildDTO(doctorDTO));
    }

    @Override
    public void removeDoctor(String patient, String doctor) {
        PatientDTO patientDTO = findOne(patient);
        if(patientDTO == null) throw new Exceptions(ResultEnum.PATIENT_NOT_EXIST);

        DoctorDTO doctorDTO = doctorMapper.doctorToDoctorDTO(doctorRepository.findById(doctor).orElse(null));
        if(doctorDTO == null) throw new Exceptions(ResultEnum.DOCTOR_NOT_EXIST);

        doctorDTO.getPatients().remove(patientMapper.patientDTOToPatientChildDTO(patientDTO));
        patientDTO.getDoctors().remove(doctorMapper.doctorDTOToDoctorChildDTO(doctorDTO));
    }
}
