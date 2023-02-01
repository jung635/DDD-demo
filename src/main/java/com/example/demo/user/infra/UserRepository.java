package com.example.demo.user.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByOrderByIdDesc();
}
