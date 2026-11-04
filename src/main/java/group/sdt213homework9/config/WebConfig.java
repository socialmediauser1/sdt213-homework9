package group.sdt213homework9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring MVC configuration written in Java (section 3 of the tutorial).
 */
@EnableWebMvc // turns on Spring MVC: controller mappings, type converters, validation, message converters, exception handling
@Configuration // this class is a source of bean definitions
@ComponentScan(basePackages = {"group.sdt213homework9.web.controller"}) // find the @Controller classes in this package
public class WebConfig implements WebMvcConfigurer { // WebMvcConfigurer lets us customize the default MVC setup

    /**
     * Maps the URL "/" straight to the view "index", without writing a controller.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * Turns a view name returned by a controller into a JSP file.
     * For example "sample" becomes /WEB-INF/view/sample.jsp.
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class); // JSP views with JSTL support
        bean.setPrefix("/WEB-INF/view/"); // folder of the JSP files
        bean.setSuffix(".jsp"); // file extension

        return bean;
    }
}
