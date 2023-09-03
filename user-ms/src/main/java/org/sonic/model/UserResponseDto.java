package org.sonic.model;

import lombok.Data;
import org.sonic.entity.AppUserRole;

import java.util.List;

@Data
public class UserResponseDto {

    private String username;
    private String email;
    List<AppUserRole> appAppUserRoles;
}
