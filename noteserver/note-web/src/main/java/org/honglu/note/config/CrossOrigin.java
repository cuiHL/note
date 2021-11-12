package org.honglu.note.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc
public class CrossOrigin extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration resourceHandlerRegistration = registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost")
                .allowCredentials(true)
                .allowedMethods("PUT", "POST", "GET", "OPTIONS", "DELETE")
                .maxAge(3600);
    }
}

//
//@Configuration
//@EnableWebMvc
//public class CrossOrigin implements WebMvcConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        ResourceHandlerRegistration resourceHandlerRegistration = registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost")
//                .allowedMethods("*")
//                .allowedHeaders("*");
//    }
//}
