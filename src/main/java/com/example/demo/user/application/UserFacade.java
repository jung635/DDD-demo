package com.example.demo.user.application;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserCommand;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;

    public String registerUser(UserCommand.RegisterUserReq registerUserReq) {
       return  userService.insertUser(registerUserReq);
    }

    public List<User> getUsers() {
        return userService.selectUsers();
    }

}
