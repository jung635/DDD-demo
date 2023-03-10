package com.example.demo.user.interfaces.todo;

import com.example.demo.user.common.response.CommonResponse;
import com.example.demo.user.interfaces.communication.GrpcClient;
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
    private final GrpcClient grpcClient;

    @PostMapping(value="/addTodo")
    public CommonResponse<String> addTodo(@RequestBody TodoDto.AddTodo req) throws InterruptedException {
        String respMsg = grpcClient.addTodo(todoDtoMapper.of(req).toGrpcReq());
        return CommonResponse.success(respMsg);
    }
    
}
