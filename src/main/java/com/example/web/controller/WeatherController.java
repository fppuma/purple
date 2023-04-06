package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.configuration.WeatherServiceConfiguration;

@RestController
public class WeatherController {
  @Autowired
  WeatherServiceConfiguration configuration;

  @RequestMapping("weather")
  public WeatherServiceConfiguration getConfiguration() {
    return configuration;
  }
}
