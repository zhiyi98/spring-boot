package com.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.annotation.RateLimiter;
import com.springboot.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 */
@Slf4j
@RestController
public class PersonController {

  @RateLimiter(value = 1.0, timeout = 300)
  @GetMapping("/test1")
  public String test1() {
    log.info("【test1】被执行了。。。。。");
    Person person = new Person(1,"trump","M");
    return JSON.toJSONString(person);
  }

  @GetMapping("/test2")
  public String test2() {
    log.info("【test2】被执行了。。。。。");
    Person person = new Person(2,"obama","M");
    return JSON.toJSONString(person);
  }

  @RateLimiter(value = 2.0, timeout = 300)
  @GetMapping("/test3")
  public String test3() {
    log.info("【test3】被执行了。。。。。");
    Person person = new Person(3,"biden","M");
    return JSON.toJSONString(person);
  }
}
