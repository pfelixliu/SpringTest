# SpringTest

这是一个Spring Boot用户管理系统演示项目。

## 项目功能

- 用户信息的增删改查（CRUD操作）
- RESTful API设计
- 根据姓名搜索用户
- 单元测试覆盖

## 技术栈

- **框架**: Spring Boot 2.3.2.RELEASE
- **Java版本**: 1.8
- **构建工具**: Maven
- **测试框架**: JUnit 5

## API端点

### 基础信息
- `GET /` - 获取欢迎信息和API文档

### 用户管理
- `GET /api/users` - 获取所有用户
- `GET /api/users/{id}` - 根据ID获取用户
- `POST /api/users` - 创建新用户
- `PUT /api/users/{id}` - 更新用户信息
- `DELETE /api/users/{id}` - 删除用户
- `GET /api/users/search?name=xxx` - 按姓名搜索用户

## 运行项目

1. 克隆项目：
```bash
git clone https://github.com/pfelixliu/SpringTest.git
cd SpringTest/demo
```

2. 运行项目：
```bash
mvn spring-boot:run
```

或者使用IDE运行`DemoApplication.java`类。

3. 访问应用：
- 打开浏览器访问 http://localhost:8080
- API测试可以使用Postman或curl

## 示例请求

### 创建用户
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"新用户","email":"newuser@example.com","age":25}'
```

### 获取所有用户
```bash
curl http://localhost:8080/api/users
```

### 搜索用户
```bash
curl "http://localhost:8080/api/users/search?name=张"
```

## 运行测试

```bash
mvn test
```

## 项目结构

```
demo/
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java          # 应用启动类
│   ├── controller/
│   │   ├── UserController.java       # 用户控制器
│   │   └── WelcomeController.java    # 欢迎控制器
│   ├── model/
│   │   └── User.java                 # 用户实体类
│   └── service/
│       ├── UserService.java          # 用户服务接口
│       └── UserServiceImpl.java      # 用户服务实现
└── src/test/java/
    └── UserServiceTest.java          # 用户服务测试
```