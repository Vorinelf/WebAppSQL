package com.artem.command;

import com.artem.filter.ClientType;
import com.artem.methods.LoginMethods;
import com.artem.session.SessionLocator;
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
        HttpSession session;
        ClientType clientType;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = loginMethods.checkLoginOrNewUser(login, password);
        if (user != null) {
            if (user.isAdmin()) {
                clientType = ClientType.ADMIN;
                request.getSession().invalidate();
                session = request.getSession(true);
                session.setMaxInactiveInterval(60*5);
                session.setAttribute("messages", SessionLocator.addMessage(session));
                session.setAttribute("role", clientType);
            } else {
                clientType = ClientType.USER;
                request.getSession().invalidate();
                session = request.getSession(true);
                session.setMaxInactiveInterval(60*5);
                session.setAttribute("messages", SessionLocator.addMessage(session));
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
