package com.artem.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class User {
    private String firstName, secondName, login, password;
    boolean isAdmin;

}
