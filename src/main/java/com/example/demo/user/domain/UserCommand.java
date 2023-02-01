package com.example.demo.user.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserCommand {

    @Getter
    @Builder
    public static class RegisterUserReq {
        private String userId;
        private String name;
        private String password;

        public User toEntity() {
            return User.builder()
                .userId(userId)
                .name(name)
                .password(password)
                .build();
        }
    }
}
