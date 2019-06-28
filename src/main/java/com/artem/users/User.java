package com.artem.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class User {
    boolean isAdmin;
    private String login, password, firstName, secondName, country, city, street, postIndex, phone;
}
