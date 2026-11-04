# SDT 213 Homework 9 – Spring MVC Tutorial

The example from the [Baeldung Spring MVC Tutorial](https://www.baeldung.com/spring-mvc-tutorial),
built with Spring Framework 7, Jakarta Servlet 6.1 and Java 17.

## Project structure

| File | Tutorial section | What it does |
|------|------------------|--------------|
| `config/WebConfig.java` | 3 | Java configuration: `@EnableWebMvc`, view controller `/` → `index`, JSP view resolver |
| `config/MainWebAppInitializer.java` | 3 | Starts Spring and registers the `DispatcherServlet` at `/` (replaces web.xml) |
| `WEB-INF/xml-config.xml`, `WEB-INF/web.xml` | 4 | The same configuration in XML, on a second `DispatcherServlet` at `/xml/*` |
| `web/controller/SampleController.java` | 5 | `GET /sample` → view `sample` |
| `WEB-INF/view/sample.jsp`, `index.jsp` | 5 | JSP views, hidden inside WEB-INF |
| `spring-boot-version/` | 6 | The same example with Spring Boot and Thymeleaf |
| `SampleControllerTest.java` | – | MockMvc tests for the Java configuration |

## Run

Java and XML configuration (Jetty):

```bash
./mvnw jetty:run
```

- http://localhost:8080/spring-mvc-basics/ – index page (Java configuration)
- http://localhost:8080/spring-mvc-basics/sample – sample view (Java configuration)
- http://localhost:8080/spring-mvc-basics/xml/ – index page (XML configuration)
- http://localhost:8080/spring-mvc-basics/xml/sample – sample view (XML configuration)

Spring Boot version:

```bash
./mvnw -f spring-boot-version/pom.xml spring-boot:run
```

- http://localhost:8081/ and http://localhost:8081/sample

Tests:

```bash
./mvnw test
```
