package com.david.citasMedicas.service.implementation;

import com.david.citasMedicas.DTO.UserDTO;
import com.david.citasMedicas.DTO.mapper.UserMapper;
import com.david.citasMedicas.entity.User;
import com.david.citasMedicas.exception.Exceptions;
import com.david.citasMedicas.exception.enums.ResultEnum;
import com.david.citasMedicas.repository.UserRepository;
import com.david.citasMedicas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){ this.userRepository=userRepository;}

    @Override
    public UserDTO findOne(String user) {
        User user1 = userRepository.findById(user).orElse(null);
        if(user1 == null) throw new Exceptions(ResultEnum.USER_NOT_EXIST);
        return userMapper.userToUserDTO(user1);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return userMapper.userListToUserDTOList(users);
    }

    @Override
    public void delete(String user) {
        UserDTO userDTO = findOne(user);
        if(userDTO == null) throw new Exceptions(ResultEnum.USER_NOT_EXIST);
        userRepository.deleteById(user);
    }
}
