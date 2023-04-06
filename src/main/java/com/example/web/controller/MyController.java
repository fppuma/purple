package com.example.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
  @GetMapping("message")
  public String getMessage() {
    return "Purple is a beautiful color";
  }
}
