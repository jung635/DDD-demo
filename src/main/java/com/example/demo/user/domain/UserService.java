package com.example.demo.user.domain;

import java.util.List;

public interface UserService {
    List<User> selectUsers();
    String insertUser(UserCommand.RegisterUserReq command);
}
