package com.example.demo.user.domain.todo;

public interface TodoApiCaller {

    String addTodo(TodoCommand.AddTodoReq req);
}
