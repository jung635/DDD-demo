package com.example.demo.user.infra.retrofit;

import com.example.demo.user.common.response.CommonResponse;
import com.example.demo.user.common.utils.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RetrofitUtils {
    private static String PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final HttpLoggingInterceptor LOGGING_INTERCEPTOR
            = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(3, TimeUnit.SECONDS)
            .addInterceptor(LOGGING_INTERCEPTOR)
            .build();
    public static Retrofit initRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(HTTP_CLIENT)
                .addConverterFactory(GsonConverterFactory.create(GsonUtil.gson))
                .build();
    }

    public <T extends CommonResponse> Optional<T> responseSync(Call<T> call) {
        try {
            Response<T> execute = call.execute();
            if(execute.isSuccessful()) {
                return Optional.ofNullable(execute.body());
            }else {
                log.error("responseSync errorBody = {}", execute.errorBody());
                throw new RuntimeException("retrofit execute response error");
            }
        } catch (IOException e) {
            log.error("", e);
            throw new RuntimeException("retrofit execute IOException");
        }
    }
}
