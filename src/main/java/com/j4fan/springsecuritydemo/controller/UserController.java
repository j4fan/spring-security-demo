package com.j4fan.springsecuritydemo.controller;

import com.j4fan.springsecuritydemo.annotations.CheckBindingResult;
import com.j4fan.springsecuritydemo.common.Result;
import com.j4fan.springsecuritydemo.common.ResultGenerator;
import com.j4fan.springsecuritydemo.domin.UserDTO;
import com.j4fan.springsecuritydemo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @CheckBindingResult
    public Result userLogin(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        return ResultGenerator.genSuccessResult(userService.saveUser(userDTO));
    }

}
