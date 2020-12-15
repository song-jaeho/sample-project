package com.sampleproject.sampleproject.controller;

import javax.validation.Valid;

import com.sampleproject.sampleproject.dto.UserForm;
import com.sampleproject.sampleproject.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
// 초기화 되지 않은 final 필드나, @NonNull 이 붙은 필드의 생성자를 생성해 준다.
// 주로 의존성 주입 편의성을 위해서 사용된다.
// @Autowired 없이 의존성 주입이 가능하다.
@RequiredArgsConstructor
@ResponseBody
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/signup")
    public void signUpUser(@RequestBody @Valid UserForm userForm) throws Exception {
        userService.signUpUser(userForm);
    }
}
