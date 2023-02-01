package com.example.demo.user.domain;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import com.example.demo.user.common.utils.TokenGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

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
    private String pw;

    @Builder
    public User(String userId, String name, String pw) {
        if(StringUtils.isBlank(userId)) throw new InvalidParameterException("User.userId");
        if(StringUtils.isBlank(name)) throw new InvalidParameterException("User.name");
        if(StringUtils.isBlank(pw)) throw new InvalidParameterException("User.pw");
        this.userId = userId;
        this.name = name;
        this.pw = pw;
    }
}
