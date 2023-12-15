package com.david.citasMedicas.DTO;

import com.david.citasMedicas.DTO.childDTO.DoctorChildDTO;
import com.david.citasMedicas.DTO.childDTO.PatientChildDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class AppointmentDTO {
    private String Id;
    private int attribute11;
    private Date dateHour;
    private String reason;
    private DoctorChildDTO doctor;
    private PatientChildDTO patient;
    private DiagnosisDTO diagnosis;
}
