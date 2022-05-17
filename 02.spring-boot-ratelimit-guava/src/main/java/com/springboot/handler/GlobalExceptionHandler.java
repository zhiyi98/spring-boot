package com.springboot.handler;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局异常拦截
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  public String handler(RuntimeException ex) {
    log.info("【执行全局异常】");
    List list = new ArrayList<>();
    list.add("msg");
    list.add("手速太快了");
    list.add("500");
    return JSON.toJSONString(list);
  }
}
