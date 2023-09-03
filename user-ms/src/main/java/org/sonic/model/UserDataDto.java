package org.sonic.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.sonic.entity.AppUserRole;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDataDto {

    private String username;
    private String email;
    private String password;
    List<AppUserRole> appAppUserRoles;
}
