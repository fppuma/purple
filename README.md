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

## Actuator
Add this in the pom.xml
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Start the application and check this url:
```
http://localhost:8080/actuator
```

The url with slash at the end doesn't work:
```
http://localhost:8080/actuator/
```

To see more endpoint like configprops, env, loggers, metrics, etc.  
In the application.properties, add this configuration:
```
management.endpoints.web.exposure.include=*
```
