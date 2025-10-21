package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试类
 * @author felixliu
 */
@SpringBootTest
public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    void testGetUserById() {
        Optional<User> user = userService.getUserById("1");
        assertTrue(user.isPresent());
        assertEquals("张三", user.get().getName());
    }

    @Test
    void testCreateUser() {
        User newUser = new User();
        newUser.setName("测试用户");
        newUser.setEmail("test@example.com");
        newUser.setAge(25);

        User createdUser = userService.createUser(newUser);
        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertEquals("测试用户", createdUser.getName());
    }

    @Test
    void testUpdateUser() {
        User updatedUser = new User();
        updatedUser.setName("更新的用户");
        updatedUser.setEmail("updated@example.com");
        updatedUser.setAge(30);

        Optional<User> result = userService.updateUser("1", updatedUser);
        assertTrue(result.isPresent());
        assertEquals("更新的用户", result.get().getName());
    }

    @Test
    void testDeleteUser() {
        boolean deleted = userService.deleteUser("1");
        assertTrue(deleted);

        Optional<User> user = userService.getUserById("1");
        assertFalse(user.isPresent());
    }
}