package com.artem.command;

import com.artem.methods.LoginMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final Command INSTANCE = new LoginCommand();
    private final LoginMethods loginMethods = LoginMethods.getInstance();

    private LoginCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = loginMethods.checkLoginOrNewUser(login, password);
        if (user != null) {
            request.setAttribute("user", user);
            page = "checkLoginOk.jsp";
        } else {
            page = "checkLoginError.jsp";
        }
        return page;
    }
}
