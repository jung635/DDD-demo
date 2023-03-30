package com.example.demo.user.infra.todo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.grpc.lib.TodoAddRequest;
import org.example.grpc.lib.TodoGrpc;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Slf4j
@Service
@RequiredArgsConstructor
public class GrpcTodo {

    public String addTodo(final TodoAddRequest request) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 9090)
                .usePlaintext()
                .build();
        TodoGrpc.TodoBlockingStub blockingStub = TodoGrpc.newBlockingStub(channel);
        log.info("GrpcClient.addTodo message ==> {}", request.toString());
        String message = blockingStub.addTodo(request).getMessage();
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);

        return message;
    }
}
