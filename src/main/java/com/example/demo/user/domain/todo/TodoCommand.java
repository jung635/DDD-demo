package com.example.demo.user.domain.todo;

import lombok.Builder;
import lombok.Getter;
import org.example.grpc.lib.TodoAddRequest;

import java.time.LocalDateTime;

public class TodoCommand {

    @Getter
    @Builder
    public static class AddTodoReq {
        private String title;
        private LocalDateTime expectedDate;
        private Long userId;

        public TodoAddRequest toGrpcReq() {
            return TodoAddRequest.newBuilder()
                    .setTitle(this.title)
                    .setExpectedDate(String.valueOf(this.expectedDate))
                    .setUserId(String.valueOf(this.userId))
                    .build();
        }
    }
}
