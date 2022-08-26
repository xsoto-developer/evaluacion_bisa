package com.bisa.evaluacion.evaluacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

//@Configuration
//@EnableSwagger2
////@EnableSwagger2WebMvc
//@EnableWebMvc
//@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {
//    @Bean
//    public Docket documentation(){
//        return  new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .paths(PathSelectors.any())
//                .build();
//    }
}

/*public class SwaggerConfig extends WebMvcConfigurerAdapter {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}*/


/*public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("com.openwebinars.net.rest.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}*/
