package com.example.demo.user.service;

import java.util.List;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserCommand;

public interface UserService {
    List<User> selectUsers();
    String insertUser(UserCommand.RegisterUserReq command);
}
