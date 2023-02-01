package com.example.demo.user.infra;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserReader;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {
    private final UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAllByOrderByIdDesc();
    }
}
