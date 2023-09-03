package org.sonic.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.sonic.user.entity.AppUserRole;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDataDto {

    private String username;
    private String email;
    private String password;
    List<AppUserRole> appAppUserRoles;
}
