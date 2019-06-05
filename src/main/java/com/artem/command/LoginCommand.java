package com.artem.command;

import com.artem.filter.ClientType;
import com.artem.methods.LoginMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            HttpSession session;
            ClientType clientType;
            if (user.isAdmin() == true) {
                clientType = ClientType.ADMIN;
                session = request.getSession();
                session.setAttribute("role", clientType);
            } else {
                clientType = ClientType.USER;
                session = request.getSession();
                session.setAttribute("role", clientType);
            }
            request.setAttribute("user", user);
            page = "checkLoginOk.jsp";
        } else {
            page = "checkLoginError.jsp";
        }
        return page;
    }
}
