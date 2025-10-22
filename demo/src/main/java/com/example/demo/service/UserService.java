package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

/**
 * 用户服务接口
 * @author felixliu
 */
public interface UserService {

    /**
     * 获取所有用户
     * @return 用户列表
     */
    List<User> getAllUsers();

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 用户信息
     */
    Optional<User> getUserById(String id);

    /**
     * 创建新用户
     * @param user 用户信息
     * @return 创建的用户
     */
    User createUser(User user);

    /**
     * 更新用户信息
     * @param id 用户ID
     * @param user 用户信息
     * @return 更新后的用户
     */
    Optional<User> updateUser(String id, User user);

    /**
     * 删除用户
     * @param id 用户ID
     * @return 是否删除成功
     */
    boolean deleteUser(String id);
}
