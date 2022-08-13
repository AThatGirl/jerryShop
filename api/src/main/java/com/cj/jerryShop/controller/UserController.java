package com.cj.jerryShop.controller;

import com.cj.jerryShop.entity.Users;
import com.cj.jerryShop.service.UserService;
import com.cj.jerryShop.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Api(value = "提供用户登陆注册的接口",tags = "用户管理")
//解决跨域问题
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username",value = "用户登录账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password",value = "用户登录密码",required = true),
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String name, @RequestParam(value = "password") String password){
        return userService.checkLogin(name,password);
    }

    @ApiOperation("用户注册接口")
    @PostMapping("/register")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username",value = "用户注册账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password",value = "用户注册密码",required = true),
    })
    public ResultVO register(@RequestBody Users users){
        return userService.userRegister(users.getUsername(),users.getPassword());
    }

}
