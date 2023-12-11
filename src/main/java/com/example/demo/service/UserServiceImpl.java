package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
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
    public User createUser(User user) {
        if (user.getEmail() == null  || user.getEmail().isEmpty()) {
            return null;
        }
        if (user.getName() == null  || user.getName().isEmpty()) {
            return null;
        }
        return userRepository.save(user);
    }
}
