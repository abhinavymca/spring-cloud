package org.sonic;

import lombok.RequiredArgsConstructor;
import org.sonic.entity.AppUser;
import org.sonic.entity.AppUserRole;
import org.sonic.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
@RequiredArgsConstructor
public class UserApplication implements CommandLineRunner {

    final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Override
    public void run(String... params) throws Exception {
        AppUser admin = new AppUser();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEmail("admin@email.com");
        admin.setAppUserRoles(new ArrayList<>(Arrays.asList(AppUserRole.ROLE_ADMIN)));

        userService.signup(admin);

        AppUser client = new AppUser();
        client.setUsername("client");
        client.setPassword("client");
        client.setEmail("client@email.com");
        client.setAppUserRoles(new ArrayList<>(Arrays.asList(AppUserRole.ROLE_CLIENT)));

        userService.signup(client);
    }

}