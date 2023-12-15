package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.DiagnosisDTO;
import com.david.citasMedicas.entity.Diagnosis;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiagnosisMapper {

    DiagnosisMapper INSTANCE = Mappers.getMapper(DiagnosisMapper.class);

    DiagnosisDTO diagnosisToDiagnosisDTO(Diagnosis diagnosis);
    Diagnosis diagnosisDTOToDiagnosis(DiagnosisDTO diagnosisDTO);
    List<DiagnosisDTO> diagnosisListToDiagnosisDTOList(List<Diagnosis> diagnosis);
    List<Diagnosis> diagnosisDTOListToDiagnosisList(List<DiagnosisDTO> diagnosisDTOS);
}
