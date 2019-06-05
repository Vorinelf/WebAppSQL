package com.artem.command;

import com.artem.methods.LoginMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    private static final Command INSTANCE = new RegistrationCommand();
    private final LoginMethods loginMethods = LoginMethods.getInstance();

    private RegistrationCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
        User userAfterCheck = loginMethods.checkLoginOrNewUser(login, password);
        if (userAfterCheck!= null) {
            page = "registrationError.jsp";
        } else {
            User user = new User(firstName, secondName, login, password,isAdmin);
            loginMethods.registration(user);
            request.setAttribute("user", user);
            page = "registrationOk.jsp";
        }
        return page;
    }
}
