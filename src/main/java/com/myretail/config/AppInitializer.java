package com.myretail.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletRegistration.Dynamic;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * AppInitializer is used as the replacement for your typical web.xml file. since Servlet 3.0 java web applications are
 * capable of running without a web.xml.
 *
 * Spring looks for the existance of WebApplicationInitializer within an application and if found will use the settings
 * defined by it's implementing class.  Basically, think WebApplicationInitializer as the replacement for web.xml
 * just like @Configuration and component scanning is the replacement for typical Spring XML configuration files.
 */
public class AppInitializer implements WebApplicationInitializer {


    /**
     * {@inheritDoc}
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Create the 'root' Spring application context
        final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        // Manage the lifecycle of the root application context
        rootContext.register(AppConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Register and map the dispatcher servlet
        rootContext.setServletContext(servletContext);
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);

    }
}
