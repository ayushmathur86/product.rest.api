package com.adidas.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication(scanBasePackages = { "com.adidas.products" })
@EnableJms
@ComponentScan(basePackages = "com.adidas.products")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
