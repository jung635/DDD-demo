package com.example.demo.user.interfaces.todo;

import com.example.demo.user.common.response.CommonResponse;
import com.example.demo.user.domain.todo.TodoApiCaller;
import com.example.demo.user.infra.todo.GrpcTodo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TodoController {
    private final TodoDtoMapper todoDtoMapper;
    private final GrpcTodo grpcTodo;
    private final TodoApiCaller todoApiCaller;

    @PostMapping(value="/addTodo")
    public CommonResponse<String> addTodo(@RequestBody TodoDto.AddTodo req) throws InterruptedException {
        String respMsg = grpcTodo.addTodo(todoDtoMapper.of(req).toGrpcReq());
        return CommonResponse.success(respMsg);
    }

    @PostMapping(value="/api/v1/user/addTodo")
    public CommonResponse<String> addTodoApi(@RequestBody TodoDto.AddTodo req) {
        String respMsg = todoApiCaller.addTodo(todoDtoMapper.of(req));
        return CommonResponse.success(respMsg);
    }
    
}
