package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    private  static  ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1,"Lê Đoàn Anh Quân","quanchinh@gmail.com","0866877618","avatar","123"));
        users.add(new User(2,"Lê Đoàn Tuan Vũ","quanchinh@gmail.com","0866877618","avatar","123"));
        users.add(new User(3,"Trần Thị Diem Quynh","quanchinh@gmail.com","0866877618","avatar","123"));
    }

    @Override
    public List<UserDto> getListUser() {
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
}
