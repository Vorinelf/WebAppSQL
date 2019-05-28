package com.artem.command;

import com.artem.methods.AllMethodsBathroom;
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
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User(firstName, secondName, login, password);
        boolean result = loginMethods.registration(user);
        if (result)
            return "registrationOk.jsp";
        else {
            return "errorRegistration.jsp";
        }
    }
}
