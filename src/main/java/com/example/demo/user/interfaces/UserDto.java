package com.example.demo.user.interfaces;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

public class UserDto {

    @ToString
    @Getter
    @Builder
    public static class RegisterUserReq {
        private String userId;
        private String name;
        private String password;
    }
}
