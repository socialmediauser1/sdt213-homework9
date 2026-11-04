package group.sdt213homework9.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot entry point (section 6.2 of the tutorial).
 * Boot starts an embedded Tomcat and sets up the DispatcherServlet by itself,
 * so no WebConfig, initializer or web.xml is needed.
 */
// @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan (this package and below)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
