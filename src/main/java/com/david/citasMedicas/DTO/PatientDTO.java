package com.david.citasMedicas.DTO;

import com.david.citasMedicas.DTO.childDTO.AppointmentChildDTO;
import com.david.citasMedicas.DTO.childDTO.DoctorChildDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter @Getter
public class PatientDTO extends UserDTO{
    private String direction;
    private String NSS;
    private String numCard;
    private String telephone;
    private List<DoctorChildDTO> doctors = new ArrayList<>();
    private List<AppointmentChildDTO> appointments = new ArrayList<>();

}
