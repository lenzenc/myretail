package com.myretail.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * AppConfig serves as the root Spring configuration class for My Retail.
 */
@EnableWebMvc
@ComponentScan("com.myretail")
@Configuration
public class AppConfig {
}
