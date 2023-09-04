package org.sonic.nextflix.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NetflixEurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaMain.class, args);
    }
}