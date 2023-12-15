package com.david.citasMedicas.service.implementation;

import com.david.citasMedicas.DTO.DoctorDTO;
import com.david.citasMedicas.DTO.PatientDTO;
import com.david.citasMedicas.DTO.mapper.DoctorMapper;
import com.david.citasMedicas.DTO.mapper.PatientMapper;
import com.david.citasMedicas.entity.Doctor;
import com.david.citasMedicas.entity.Patient;
import com.david.citasMedicas.exception.Exceptions;
import com.david.citasMedicas.exception.enums.ResultEnum;
import com.david.citasMedicas.repository.DoctorRepository;
import com.david.citasMedicas.repository.PatientRepository;
import com.david.citasMedicas.service.DoctorService;
import com.david.citasMedicas.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;

    private final DoctorMapper doctorMapper = DoctorMapper.INSTANCE;

    private final PatientMapper patientMapper = PatientMapper.INSTANCE;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository){
        this.doctorRepository=doctorRepository;
        this.patientRepository=patientRepository;
    }

    @Override
    public DoctorDTO findOne(String user) {
        Doctor doctor = doctorRepository.findById(user).orElse(null);
       /* if(doctor == null) throw new Exceptions(ResultEnum.DOCTOR_NOT_EXIST);*/
        return doctorMapper.doctorToDoctorDTO(doctor);
    }

    @Override
    public List<DoctorDTO> findAll() {
        List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();
        return doctorMapper.doctorListToDoctorDTOList(doctors);
    }

    @Override
    public DoctorDTO create(DoctorDTO doctorDTO) {
        String user = doctorDTO.getUser();
        if(findOne(user) != null) throw new Exceptions(ResultEnum.DOCTOR_EXIST);
        doctorRepository.save(doctorMapper.doctorDTOToDoctor(doctorDTO));
        return doctorDTO;
    }

    @Override
    public void modify(DoctorDTO doctorDTO) {
        String user = doctorDTO.getUser();
        if(findOne(user) == null) throw new Exceptions(ResultEnum.DOCTOR_NOT_EXIST);
        doctorRepository.save(doctorMapper.doctorDTOToDoctor(doctorDTO));
    }

    @Override
    public void delete(String user) {
        DoctorDTO doctorDTO = findOne(user);
        if(doctorDTO == null) throw new Exceptions(ResultEnum.DOCTOR_NOT_EXIST);
        doctorRepository.delete(doctorMapper.doctorDTOToDoctor(doctorDTO));
    }

    @Override
    public void addPatient(String doctor, String patient) {
        DoctorDTO doctorDTO = findOne(doctor);
        if(doctorDTO == null) throw new Exceptions(ResultEnum.DOCTOR_NOT_EXIST);

        PatientDTO patientDTO = patientMapper.patientToPatientDTO(patientRepository.findById(patient).orElse(null));
        if(patientDTO == null) throw new Exceptions(ResultEnum.PATIENT_NOT_EXIST);

        patientDTO.getDoctors().add(doctorMapper.doctorDTOToDoctorChildDTO(doctorDTO));
        doctorDTO.getPatients().add(patientMapper.patientDTOToPatientChildDTO(patientDTO));
    }

    @Override
    public void removePatient(String doctor, String patient) {
        DoctorDTO doctorDTO = findOne(doctor);
        if(doctorDTO == null) throw new Exceptions(ResultEnum.DOCTOR_NOT_EXIST);

        PatientDTO patientDTO = patientMapper.patientToPatientDTO(patientRepository.findById(patient).orElse(null));
        if(patientDTO == null) throw new Exceptions(ResultEnum.PATIENT_NOT_EXIST);

        patientDTO.getDoctors().remove(doctorMapper.doctorDTOToDoctorChildDTO(doctorDTO));
        doctorDTO.getPatients().remove(patientMapper.patientDTOToPatientChildDTO(patientDTO));
    }
}
