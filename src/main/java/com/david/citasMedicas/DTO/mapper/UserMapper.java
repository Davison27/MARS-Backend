package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.UserDTO;
import com.david.citasMedicas.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
    List<UserDTO> userListToUserDTOList(List<User> users);
    List<User> userDTOListToUserList(List<UserDTO> userDTOS);

}
