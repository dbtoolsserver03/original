package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;

@SpringBootApplication
//@EnableDiscoveryClient
public class AdminGatewayApplication {
    public static void main(String[] args) {

        GatewayFilterFactory GatewayFilterFactory;

        SpringApplication.run(AdminGatewayApplication.class, args);
    }
}
