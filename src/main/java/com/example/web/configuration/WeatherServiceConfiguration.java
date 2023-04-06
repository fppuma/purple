package com.example.web.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="weather-service")
@Data
public class WeatherServiceConfiguration {
  private String url;
  private String username;
  private String key;
}