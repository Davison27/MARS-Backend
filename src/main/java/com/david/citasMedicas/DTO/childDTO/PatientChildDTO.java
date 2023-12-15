package com.david.citasMedicas.DTO.childDTO;

import com.david.citasMedicas.DTO.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PatientChildDTO extends UserDTO {
    private String direction;
    private String NSS;
    private String numCard;
    private String telephone;
}
