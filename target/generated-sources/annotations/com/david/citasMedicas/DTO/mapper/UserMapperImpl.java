package com.david.citasMedicas.DTO.mapper;

import com.david.citasMedicas.DTO.UserDTO;
import com.david.citasMedicas.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-11T12:56:09+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setName( user.getName() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setSurnames( user.getSurnames() );
        userDTO.setUser( user.getUser() );

        return userDTO;
    }

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setName( userDTO.getName() );
        user.setPassword( userDTO.getPassword() );
        user.setSurnames( userDTO.getSurnames() );
        user.setUser( userDTO.getUser() );

        return user;
    }

    @Override
    public List<UserDTO> userListToUserDTOList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( userToUserDTO( user ) );
        }

        return list;
    }

    @Override
    public List<User> userDTOListToUserList(List<UserDTO> userDTOS) {
        if ( userDTOS == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOS.size() );
        for ( UserDTO userDTO : userDTOS ) {
            list.add( userDTOToUser( userDTO ) );
        }

        return list;
    }
}
