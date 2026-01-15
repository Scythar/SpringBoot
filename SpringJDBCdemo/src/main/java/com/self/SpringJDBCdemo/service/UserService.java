package com.self.SpringJDBCdemo.service;


import com.self.SpringJDBCdemo.dto.UserRequestDTO;
import com.self.SpringJDBCdemo.dto.UserResponseDTO;
import com.self.SpringJDBCdemo.exception.UserNotFoundException;
import com.self.SpringJDBCdemo.model.User;
import com.self.SpringJDBCdemo.repository.AuthUserRepository;
import com.self.SpringJDBCdemo.repository.UserRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // Autowired annotation is only needed when there is more than one class constructor present here, but that not the case so it is not necessary.
//    @Autowired
    private final UserRepository userRepository;

//    @Autowired
    private final AuthUserRepository authUserRepository;
//    @Autowired
    final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, AuthUserRepository authUserRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.authUserRepository = authUserRepository;
        this.modelMapper = modelMapper;
    }


    public UserResponseDTO createUser(UserRequestDTO data) {
        User entity = modelMapper.map(data, User.class);
        User savedEntity = userRepository.save(entity);
        return modelMapper.map(savedEntity, UserResponseDTO.class);
    }

    public List<UserResponseDTO> fetchAllUser(){
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserResponseDTO.class)).toList();
    }

    public UserResponseDTO findUserById(int id){
        User entity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No record found with id " + id));
        return modelMapper.map(entity, UserResponseDTO.class);
    }

    public UserResponseDTO updateUser(int id, UserRequestDTO data){

       User entity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No record found with id " + id));
       modelMapper.map(data,entity);
       User savedEntity = userRepository.save(entity);
       return modelMapper.map(savedEntity, UserResponseDTO.class);
    }

    public UserResponseDTO deleteUser(int id) {
       User entity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No record found with id " + id));

       userRepository.deleteById(id);

       return modelMapper.map(entity, UserResponseDTO.class);
    }

    public UserResponseDTO searchUser(String name) {
        User result = userRepository.findByName(name).orElseThrow(() -> new UserNotFoundException("No record found with name " + name));

        return modelMapper.map(result, UserResponseDTO.class);
    }

    public UserResponseDTO searchUserContainingName(@Valid String name) {
        User users = userRepository.findByNameContaining(name).orElseThrow(() -> new UserNotFoundException("No record found with name " + name));

        return modelMapper.map(users, UserResponseDTO.class);
    }

    public List<UserResponseDTO> findByAgeBetween(int start, int end) {

        List<User> users = userRepository.findByAgeBetween(start, end);

        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found between age " + start + " and " + end);
        }

        return users.stream()
                .map(u -> modelMapper.map(u, UserResponseDTO.class))
                .toList();
    }

    public List<UserResponseDTO> ageGreaterThan(int age){
        List<User> users = userRepository.findByAgeGreaterThan(age);
        if(users == null){
            throw new UserNotFoundException("No users found above age " + age);
        }
        return users.stream().map(user -> modelMapper.map(user, UserResponseDTO.class)).toList();
    }


}
