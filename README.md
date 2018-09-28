# JpaDemo
Spring-Jpa
Spring JPA 示例 ，对JPA的扩展，支持多数据源切换

# JPA 概述
主要针对的就是 Spring 唯一没有简化到的业务逻辑代码，至此，开发者连仅剩的实现持久层业务逻辑的工作都省了，唯一要做的，就只是声明持久层的接口，其他都交给 Spring Data JPA 来帮你完成！
1. Java Persistence API（Java 持久层 API）：用于对象持久化的 API
2. 作用：使得应用程序以统一的方式访问持久层
3. 前言中提到了 Hibernate，那么JPA 与 Hibernate究竟是什么关系呢：
1）JPA 是 Hibernate 的一个抽象，就像 JDBC 和 JDBC 驱动的关系
2）JPA 是一种 ORM 规范，是 Hibernate 功能的一个子集 (既然 JPA 是规范，Hibernate 对 JPA 进行了扩展，那么说 JPA 是 Hibernate 的一个子集不为过)
3）Hibernate 是 JPA 的一个实现
4. JPA 包括三个方面的技术：
1）ORM 映射元数据，支持 XML 和 JDK 注解两种元数据的形式
2）JPA 的 API
3）查询语言：JPQL
