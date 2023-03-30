package com.example.demo.user.infra.todo;

import com.example.demo.user.common.response.CommonResponse;
import com.example.demo.user.domain.todo.TodoApiCaller;
import com.example.demo.user.domain.todo.TodoCommand;
import com.example.demo.user.infra.retrofit.RetrofitUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Call;

@Component
@Slf4j
@RequiredArgsConstructor
public class TodoApiCallerImpl implements TodoApiCaller {
    private final RetrofitTodoApi retrofitTodoApi;
    private final RetrofitUtils retrofitUtils;

    @Override
    public String addTodo(TodoCommand.AddTodoReq req) {
        Call<CommonResponse<String>> call = retrofitTodoApi.addTodo(req);
        return retrofitUtils.responseSync(call)
                .map(CommonResponse::getData)
                //.map(RetrofitTodoApiResponse.AddTodo::getToken)
                .orElseThrow(RuntimeException::new);
    }
}
