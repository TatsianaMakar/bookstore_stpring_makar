package com.company;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@Import({WebConfig.class,DataConfig.class})
public class App implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

}
