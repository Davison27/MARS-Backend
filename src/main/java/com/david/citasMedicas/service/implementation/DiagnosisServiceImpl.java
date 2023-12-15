package com.david.citasMedicas.service.implementation;

import com.david.citasMedicas.DTO.DiagnosisDTO;
import com.david.citasMedicas.DTO.mapper.DiagnosisMapper;
import com.david.citasMedicas.entity.Diagnosis;
import com.david.citasMedicas.exception.Exceptions;
import com.david.citasMedicas.exception.enums.ResultEnum;
import com.david.citasMedicas.repository.DiagnosisRepository;
import com.david.citasMedicas.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    private final DiagnosisMapper diagnosisMapper = DiagnosisMapper.INSTANCE;

    @Autowired
    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository){
        this.diagnosisRepository=diagnosisRepository;
    }

    @Override
    public DiagnosisDTO findOne(String id) {
        Diagnosis diagnosis = diagnosisRepository.findById(id).orElse(null);
        if(diagnosis == null) throw new Exceptions(ResultEnum.DIAGNOSIS_NOT_EXIST);
        return diagnosisMapper.diagnosisToDiagnosisDTO(diagnosis);
    }

    @Override
    public List<DiagnosisDTO> findAll() {
        List<Diagnosis> diagnoses = (List<Diagnosis>)  diagnosisRepository.findAll();
        return diagnosisMapper.diagnosisListToDiagnosisDTOList(diagnoses);
    }

    @Override
    public DiagnosisDTO create(DiagnosisDTO diagnosisDTO) {
        String user = diagnosisDTO.getId();
        if(findOne(user) != null) throw new Exceptions(ResultEnum.DIAGNOSIS_EXIST);
        diagnosisRepository.save(diagnosisMapper.diagnosisDTOToDiagnosis(diagnosisDTO));
        return diagnosisDTO;
    }

    @Override
    public void modify(DiagnosisDTO diagnosisDTO) {
        String user = diagnosisDTO.getId();
        if(findOne(user) == null) throw new Exceptions(ResultEnum.DIAGNOSIS_NOT_EXIST);
        diagnosisRepository.save(diagnosisMapper.diagnosisDTOToDiagnosis(diagnosisDTO));
    }

    @Override
    public void delete(String id) {
        DiagnosisDTO diagnosisDTO = findOne(id);
        if(diagnosisDTO == null) throw new Exceptions(ResultEnum.DIAGNOSIS_NOT_EXIST);
        diagnosisRepository.deleteById(id);
    }
}
