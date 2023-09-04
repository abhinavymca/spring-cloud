package org.sonic.booking.config;

import org.sonic.booking.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-ms")
public interface UserDetailsProxy {

    @GetMapping(value = "/users/{username}")
    User search(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerHeader, @PathVariable String username);
}
