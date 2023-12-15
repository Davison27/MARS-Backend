package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.DiagnosisDTO;
import com.david.citasMedicas.entity.Diagnosis;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-11T12:56:09+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class DiagnosisMapperImpl implements DiagnosisMapper {

    @Override
    public DiagnosisDTO diagnosisToDiagnosisDTO(Diagnosis diagnosis) {
        if ( diagnosis == null ) {
            return null;
        }

        DiagnosisDTO diagnosisDTO = new DiagnosisDTO();

        diagnosisDTO.setDisease( diagnosis.getDisease() );
        diagnosisDTO.setId( diagnosis.getId() );
        diagnosisDTO.setSpecialistAssessment( diagnosis.getSpecialistAssessment() );

        return diagnosisDTO;
    }

    @Override
    public Diagnosis diagnosisDTOToDiagnosis(DiagnosisDTO diagnosisDTO) {
        if ( diagnosisDTO == null ) {
            return null;
        }

        Diagnosis diagnosis = new Diagnosis();

        diagnosis.setDisease( diagnosisDTO.getDisease() );
        diagnosis.setId( diagnosisDTO.getId() );
        diagnosis.setSpecialistAssessment( diagnosisDTO.getSpecialistAssessment() );

        return diagnosis;
    }

    @Override
    public List<DiagnosisDTO> diagnosisListToDiagnosisDTOList(List<Diagnosis> diagnosis) {
        if ( diagnosis == null ) {
            return null;
        }

        List<DiagnosisDTO> list = new ArrayList<DiagnosisDTO>( diagnosis.size() );
        for ( Diagnosis diagnosis1 : diagnosis ) {
            list.add( diagnosisToDiagnosisDTO( diagnosis1 ) );
        }

        return list;
    }

    @Override
    public List<Diagnosis> diagnosisDTOListToDiagnosisList(List<DiagnosisDTO> diagnosisDTOS) {
        if ( diagnosisDTOS == null ) {
            return null;
        }

        List<Diagnosis> list = new ArrayList<Diagnosis>( diagnosisDTOS.size() );
        for ( DiagnosisDTO diagnosisDTO : diagnosisDTOS ) {
            list.add( diagnosisDTOToDiagnosis( diagnosisDTO ) );
        }

        return list;
    }
}
