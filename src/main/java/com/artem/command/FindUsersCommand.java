package com.artem.command;

import com.artem.methods.UserMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindUsersCommand implements Command {
    private final static Command INSTANCE = new FindUsersCommand();
    private final UserMethods userMethods = UserMethods.getInstance();

    public static Command getInstance() {
        return INSTANCE;
    }


    @Override
    public String execute(HttpServletRequest request) {

        List<User> listOrders = userMethods.findAllUsers();
        request.setAttribute("usersArray", listOrders);

        return "usersAdmin.jsp";
    }
}
