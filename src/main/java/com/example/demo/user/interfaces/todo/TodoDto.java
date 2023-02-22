package com.example.demo.user.interfaces.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

public class TodoDto {
    @Getter
    @Builder
    public static class AddTodo {
        private String userId;
        private String title;
        private LocalDateTime expectedDate;
    }
}
