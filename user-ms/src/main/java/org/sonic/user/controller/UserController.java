package org.sonic.user.controller;

import lombok.RequiredArgsConstructor;
import org.sonic.user.config.DummyBean;
import org.sonic.user.entity.AppUser;
import org.sonic.user.model.UserDataDto;
import org.sonic.user.model.UserResponseDto;
import org.sonic.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping(value = "/signin", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody UserDataDto userLogin) {
        String token = userService.signin(userLogin.getUsername(), userLogin.getPassword());
        return new ResponseEntity<>("{\"token\":\"" + token + "\"}", HttpStatus.OK);
    }

    @PostMapping(value = "/signup", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signup(@RequestBody UserDataDto user) {
        String token = userService.signup(modelMapper.map(user, AppUser.class));
        return new ResponseEntity<>("{\"token\":\"" + token + "\"}", HttpStatus.OK);
    }

    @GetMapping(value = "/config-values", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> fetchBoot() {
        String dummyBean = userService.getConfigValues();
        return new ResponseEntity<>(dummyBean, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete( @PathVariable String username) {
        userService.delete(username);
        return username;
    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public UserResponseDto whoami(HttpServletRequest req) {
        return modelMapper.map(userService.whoami(req), UserResponseDto.class);
    }

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponseDto search(@PathVariable String username) {
        return modelMapper.map(userService.search(username), UserResponseDto.class);
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public ResponseEntity<String> refresh(HttpServletRequest req) {
        String token = userService.refresh(req.getRemoteUser());
        return new ResponseEntity<>("{\"token\":\"" + token + "\"}", HttpStatus.OK);
    }
}
