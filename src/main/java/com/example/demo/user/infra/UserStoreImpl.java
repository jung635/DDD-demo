package com.example.demo.user.infra;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserStore;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {
    private final UserRepository userRepository;
    @Override
    public User store(User user) {
        return userRepository.save(user);
    }
}
