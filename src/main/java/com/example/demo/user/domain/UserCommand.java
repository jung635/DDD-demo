package com.example.demo.user.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

public class UserCommand {

    @Getter
    @Builder
    public static class RegisterUserReq {
        private String userId;
        private String name;
        private String pw;

        public User toEntity() {
            return User.builder()
                .userId(userId)
                .name(name)
                .pw(pw)
                .build();
        }
    }
}
