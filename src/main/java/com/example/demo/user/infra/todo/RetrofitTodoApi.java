package com.example.demo.user.infra.todo;

import com.example.demo.user.common.response.CommonResponse;
import com.example.demo.user.domain.todo.TodoCommand;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RetrofitTodoApi {

    @POST("/todo")
    Call<CommonResponse<String>> addTodo(@Body TodoCommand.AddTodoReq req);
}
