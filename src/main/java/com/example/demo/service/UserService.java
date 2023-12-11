package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public List<UserDto> searchUser(String keyword);

    public User createUser(User user);
}
