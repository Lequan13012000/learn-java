package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private List<User> users;

    @Override
    public List<UserDto> getListUser() {
        users = userRepository.findAll();
        List<UserDto> result = new ArrayList<UserDto>();
        for(User user: users){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for(User user:users){
            if(user.getId() == id){
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User không tồn tại trong hệ thống");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for(User user:users){
            if(user.getName().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

    @Override
    public UserDto createUser(User user) {
        if (user.getEmail() == null  || user.getEmail().isEmpty()) {
            return null;
        }
        if (user.getName() == null  || user.getName().isEmpty()) {
            return null;
        }
        return UserMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(Long id, User user) {
        User fromDB = userRepository.findById(id).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setEmail(user.getEmail());
        fromDB.setName(user.getName());
        fromDB.setPhone(user.getPhone());
        fromDB.setAvatar(user.getPhone());
        return UserMapper.toUserDto(userRepository.save(fromDB));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
