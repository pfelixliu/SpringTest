package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 用户服务实现类
 * @author felixliu
 */
@Service
public class UserServiceImpl implements UserService {

    private final Map<String, User> userStore = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public UserServiceImpl() {
        // 初始化一些测试数据
        initTestData();
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    @Override
    public Optional<User> getUserById(String id) {
        return Optional.ofNullable(userStore.get(id));
    }

    @Override
    public User createUser(User user) {
        String id = String.valueOf(idGenerator.getAndIncrement());
        user.setId(id);
        userStore.put(id, user);
        return user;
    }

    @Override
    public Optional<User> updateUser(String id, User user) {
        if (!userStore.containsKey(id)) {
            return Optional.empty();
        }
        user.setId(id);
        userStore.put(id, user);
        return Optional.of(user);
    }

    @Override
    public boolean deleteUser(String id) {
        return userStore.remove(id) != null;
    }

    /**
     * 初始化测试数据
     */
    private void initTestData() {
        User user1 = new User("1", "张三", "zhangsan@example.com", 25);
        User user2 = new User("2", "李四", "lisi@example.com", 30);
        User user3 = new User("3", "王五", "wangwu@example.com", 28);

        userStore.put("1", user1);
        userStore.put("2", user2);
        userStore.put("3", user3);

        // 更新ID生成器
        idGenerator.set(4);
    }
}
