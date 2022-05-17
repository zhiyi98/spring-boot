package com.springboot.controller;

import com.springboot.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {


  @Log("执行方法一")
  @GetMapping("/methodOne")
  public void methodOne(Integer id) {

  }

  @Log("执行方法二")
  @GetMapping("/methodTwo")
  public void methodTwo() throws InterruptedException {
    Thread.sleep(2000);
  }

  @Log("执行方法三")
  @GetMapping("/methodThree")
  public void methodThree(String name, String age) {

  }

}
