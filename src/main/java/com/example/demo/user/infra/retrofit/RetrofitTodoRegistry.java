package com.example.demo.user.infra.retrofit;

import com.example.demo.user.infra.todo.RetrofitTodoApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

@Configuration
public class RetrofitTodoRegistry {

    @Value("${todo.baseUrl}")
    private String baseUrl;

    @Bean
    public RetrofitTodoApi retrofitTodoApi() {
        Retrofit retrofit = RetrofitUtils.initRetrofit(baseUrl);
        return retrofit.create(RetrofitTodoApi.class);
    }
}
