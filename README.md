# Spring Boot Application

## Profile
By the configuration properties
- application.properties
- application-dev.properties
- application-int.properties

Output Example
```
The following 1 profile is active: "int"
```

# Read Configuration Values
1. Create a class with Configuration Annotation. (configuration package)
2. Define a prefix
3. Go on this class as POJO
4. Print the read values by a Controller

```java
@Component
@ConfigurationProperties(prefix="weather-service")
@Data
public class WeatherServiceConfiguration {
  private String url;
  private String username;
  private String key;
}
```

```
weather-service.url=https://github.com/weather
weather-service.username=user01
weather-service.key=123
```