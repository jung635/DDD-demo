package com.example.demo.user.interfaces;

import java.util.List;

import com.example.demo.user.application.UserFacade;
import com.example.demo.user.domain.UserCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.common.response.CommonResponse;
import com.example.demo.user.domain.User;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserFacade userFacade;
    private final UserDtoMapper userDtoMapper;
    
    @GetMapping("user")
    public List<User> getUsers() {
        return userFacade.getUsers();
    }

    @PostMapping(value="/user")
    public CommonResponse<String> registerUser(@RequestBody UserDto.RegisterUserReq req) {
        log.debug("registerUser req: " + req.toString());
        UserCommand.RegisterUserReq reqCommand = userDtoMapper.of(req);
        String userId = userFacade.registerUser(reqCommand);
        return CommonResponse.success(userId);
    }
    
}
