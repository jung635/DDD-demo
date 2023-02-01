package com.example.demo.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserCommand;
import com.example.demo.user.infra.UserRepository;
import com.example.demo.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> selectUsers() {
        return userRepository.findAllByOrderByIdDesc();
    }

    @Override
    @Transactional
    public String insertUser(UserCommand.RegisterUserReq command) {
        User resultUser = userRepository.save(command.toEntity());
        return resultUser.getUserId();
    }
    
}
