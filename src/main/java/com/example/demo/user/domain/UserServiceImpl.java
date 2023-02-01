package com.example.demo.user.domain;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.infra.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserStore userStore;
    private final UserReader userReader;

    @Override
    public List<User> selectUsers() {
        return userReader.getUsers();
    }

    @Override
    @Transactional
    public String insertUser(UserCommand.RegisterUserReq command) {
        User resultUser = userStore.store(command.toEntity());
        return resultUser.getUserId();
    }
    
}
