package com.david.citasMedicas.DTO;

import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.DTO.childDTO.PatientChildDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class DoctorDTO extends UserDTO {
    private String membershipNum;
    private List<PatientChildDTO> patients = new ArrayList<>();
    private List<AppointmentChildDTO> appointments = new ArrayList<>();


}
