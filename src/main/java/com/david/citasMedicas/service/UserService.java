package com.david.citasMedicas.service;

import com.david.citasMedicas.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserDTO findOne(String user);
    List<UserDTO> findAll();
    void delete(String user);
}
