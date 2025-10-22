package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 欢迎控制器
 * @author felixliu
 */
@RestController
public class WelcomeController {

    @Value("${welcome.message:欢迎使用用户管理系统}")
    private String welcomeMessage;

    @GetMapping("/")
    public Map<String, Object> welcome() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", welcomeMessage);
        response.put("application", "Spring Boot Demo Application");
        response.put("version", "1.0.0");
        response.put("endpoints", new String[]{
                "GET /api/users - 获取所有用户",
                "GET /api/users/{id} - 获取指定用户",
                "POST /api/users - 创建新用户",
                "PUT /api/users/{id} - 更新用户信息",
                "DELETE /api/users/{id} - 删除用户",
                "GET /api/users/search?name=xxx - 按姓名搜索用户"
        });
        return response;
    }
}