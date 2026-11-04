package group.sdt213homework9.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Starts the application that uses the Java configuration (section 3 of the tutorial).
 * It replaces web.xml: the servlet container finds this class by itself when the app starts
 * and calls onStartup().
 */
public class MainWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext sc) throws ServletException {

        // Root Spring context that reads its beans from annotated classes
        AnnotationConfigWebApplicationContext root =
                new AnnotationConfigWebApplicationContext();

        // Load every @Configuration / @Controller class of our package (WebConfig, SampleController)
        root.scan("group.sdt213homework9");
        // Start the root context together with the web application and close it on shutdown
        sc.addListener(new ContextLoaderListener(root));

        // DispatcherServlet is the front controller: every request goes to it first,
        // and it sends the request to the right controller and view.
        // Its own context is empty, it uses the beans of the root context.
        ServletRegistration.Dynamic appServlet =
                sc.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1); // create the servlet when the app starts, not on the first request
        appServlet.addMapping("/"); // handle all URLs of the app
    }
}
