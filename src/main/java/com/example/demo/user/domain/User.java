package com.example.demo.user.domain;

import java.security.InvalidParameterException;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractEntity{
    private static final int TOKEN_LENGTH = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String name;
    private String password;

    @Builder
    public User(String userId, String name, String password) {
        if(StringUtils.isBlank(userId)) throw new InvalidParameterException("User.userId");
        if(StringUtils.isBlank(name)) throw new InvalidParameterException("User.name");
        if(StringUtils.isBlank(password)) throw new InvalidParameterException("User.password");
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
}
