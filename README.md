智云商城（Zhiyun Mall）是一个基于微服务架构的电商平台，涵盖了商品管理、购物车、订单处理、支付及用户管理等核心功能。该项目使用Spring Boot、MyBatis Plus、Feign等主流Java开发框架，并通过JWT实现用户认证与授权。
本项目是学习项目。
---

## 📦 项目结构

本项目由多个微服务组成，主要包括：

- **cart-service**：购物车服务，管理用户购物车中的商品。
- **item-service**：商品服务，负责商品的增删改查及库存管理。
- **trade-service**：交易服务，处理订单创建、支付状态更新等。
- **pay-service**：支付服务，支持多种支付方式，包括余额支付。
- **user-service**：用户服务，处理用户登录、地址管理等功能。
- **hm-api**：公共API模块，定义Feign客户端接口。
- **hm-common**：通用工具类与配置模块。
- **hm-gateway**：网关服务，负责路由、认证、限流等功能。
- **hm-service**：聚合服务，整合多个微服务功能，提供统一接口。

---

## 🚀 快速开始

### 环境要求

- Java 11+
- Maven 3.6+
- MySQL 5.7+
- Redis（用于用户认证）
- RabbitMQ（用于异步消息处理）

### 启动步骤

1. **克隆项目**

   ```bash
   git clone https://gitee.com/forgetting-things/zhiyun-mall.git
   cd zhiyun-mall
   ```

2. **构建项目**

   ```bash
   mvn clean install
   ```

3. **启动各微服务**

   分别进入以下目录并运行 `mvn spring-boot:run` 或打包后运行：

   - `cart-service`
   - `item-service`
   - `trade-service`
   - `pay-service`
   - `user-service`
   - `hm-gateway`
   - `hm-service`

4. **访问网关**

   默认网关地址为：`http://localhost:8080`

---

## 🧩 功能模块说明

### 1. 商品服务（item-service）

- 分页查询商品
- 根据ID查询商品
- 新增、更新、删除商品
- 批量扣减库存

### 2. 购物车服务（cart-service）

- 添加商品到购物车
- 更新购物车商品数量
- 删除购物车商品
- 查询当前用户购物车列表

### 3. 订单服务（trade-service）

- 创建订单
- 查询订单详情
- 标记订单为已支付

### 4. 支付服务（pay-service）

- 生成支付单
- 基于用户余额支付
- 查询支付状态

### 5. 用户服务（user-service）

- 用户登录
- 扣减用户余额
- 管理用户收货地址

### 6. 网关服务（hm-gateway）

- 路由转发
- JWT认证与鉴权
- 全局过滤器处理

---

## 📝 接口文档

所有接口均使用 Swagger UI 提供文档支持，访问方式如下：

```
http://localhost:<port>/swagger-ui.html
```

例如，访问商品服务的文档：

```
http://localhost:8081/swagger-ui.html
```

---

## 🔐 安全机制

- 使用 JWT 实现无状态认证
- 用户登录后返回 Token，后续请求需携带 `Authorization` 头
- 网关层统一处理认证逻辑，保护后端服务

---

## 📁 数据库结构

数据库使用 MySQL，主要表包括：

- `item`：商品表
- `cart`：购物车表
- `order`：订单表
- `pay_order`：支付单表
- `user`：用户表
- `address`：收货地址表

---

## 🧪 测试与调试

- 使用 `Postman` 或 `curl` 测试接口
- 日志文件位于 `logs/` 目录下
- 可通过 `application-local.yaml` 配置本地开发环境

---

## 🤝 贡献指南

欢迎贡献代码！请遵循以下步骤：

1. Fork 项目
2. 创建新分支 (`git checkout -b feature/your-feature`)
3. 提交更改 (`git commit -am 'Add some feature'`)
4. 推送分支 (`git push origin feature/your-feature`)
5. 创建 Pull Request
