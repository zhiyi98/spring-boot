# Spring-Boot-Redis-Cache (SpringBoot集成Redis缓存)

## 一、前言


## 二、项目介绍


## 三、开发环境

1. JDK1.8
2. Idea + Maven
3. MySQL5.5
4. Redis6.2

## 四、工程结构
```text
09.Spring-Boot-Redis-Cache
 ├── pom.xml
 ├── README.md
 └── src
     └── main
         ├── java
         │   └── com
         │       └── springboot
         │           ├── Application.java
         │           ├── ApplicationTest.java
         │           ├── bean
         │           │   └── Student.java
         │           ├── config
         │           │   └── RedisConfig.java
         │           ├── mapper
         │           │   └── StudentMapper.java
         │           └── service
         │               ├── impl
         │               │   └── StudentServiceImpl.java
         │               └── StudentService.java
         └── resources
             └── application.yml
```

## 五、项目需要的Maven依赖
```text
mysql-connector-java 8.0.29
druid-spring-boot-starter 1.2.9

spring-boot-starter-cache
spring-boot-starter-data-redis
spring-boot-starter-web
mybatis-spring-boot-starter 2.2.2
```

## 六、项目配置



