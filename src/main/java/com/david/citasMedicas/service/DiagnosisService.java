package com.david.citasMedicas.service;

import com.david.citasMedicas.DTO.DiagnosisDTO;
import com.david.citasMedicas.exception.Exceptions;

import java.util.List;

public interface DiagnosisService {

    DiagnosisDTO findOne(String id);
    List<DiagnosisDTO> findAll();
    DiagnosisDTO create(DiagnosisDTO diagnosisDTO);
    void modify(DiagnosisDTO diagnosisDTO);
    void delete(String id);
}
