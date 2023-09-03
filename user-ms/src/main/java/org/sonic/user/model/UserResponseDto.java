package org.sonic.user.model;

import lombok.Data;
import org.sonic.user.entity.AppUserRole;

import java.util.List;

@Data
public class UserResponseDto {

    private String username;
    private String email;
    List<AppUserRole> appAppUserRoles;
}
