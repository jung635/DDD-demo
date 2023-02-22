package com.example.demo.user.infra;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserStore;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {
    //private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    @Override
    public User store(User user) {
        User input = User.builder()
                .userId(user.getUserId())
                .name(user.getName())
                //.password(passwordEncoder.encode(user.getPassword())).build();
                .password(user.getPassword()).build();
        return userRepository.save(input);
    }
}
