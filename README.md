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

## Read Configuration Values
1. Create a class with Configuration Annotation. (configuration package)
2. Define a prefix
3. Go on this class as POJO
4. Print the read values by a **RestController**.

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

```java
@RestController
public class WeatherController {
  @Autowired
  WeatherServiceConfiguration configuration;

  @RequestMapping("weather")
  public WeatherServiceConfiguration getConfiguration() {
    return configuration;
  }
}
```

Start the application and check this url:
```
http://localhost:8080/weather
```

## Controller
Instead of RestController, create a **Controller**.
Add **@ResponseBody** in the endpoint.

```java
@Controller
public class HelloController {
  
  @GetMapping("hello")
  @ResponseBody
  public String getMessage() {
    return "Hello World!!!";
  }
}
```

Start the application and check this url:
```
http://localhost:8080/hello
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

To see more endpoints like configprops, env, loggers, metrics, etc.  
In the application.properties, add this configuration:
```
management.endpoints.web.exposure.include=*
```

## Redirect to JSP

```xml
<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-jasper</artifactId>
  <scope>provided</scope>
</dependency>
```

Add in the application.properties. 
For prefix, pay attention to the slash at the end.
```
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

In resources folder
- Create a folder: META-INF/resources/WEB-INF/jsp
- Inside this folder, create the file: welcome.jsp
- Add a method in HelloController.java
```java
@GetMapping("welcome")
public String welcome() {
  return "welcome";
}
```

Start the application and check this url:
```
http://localhost:8080/welcome
```

## Reading a Query Param
- Create a LoginController
- Add a method loginForm
```java
@GetMapping("login")
  public String loginForm(@RequestParam String name, ModelMap model) {
    model.put("name", name);
    return "login";
  }
```

```html
<body>
  <p style="color: blue;">Welcome ${name} </p> 

</body>
```

Start the application and check this url:
```
http://localhost:8080/login?name=Frank
```

