package org.sonic.api.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
public class ApiGatewayMain {

    @Autowired
    private DiscoveryClient discoveryClient;
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayMain.class, args);
    }
}