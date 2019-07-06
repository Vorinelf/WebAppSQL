package com.artem.command;

import com.artem.methods.UserMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteUserCommand implements Command {

    private static final Command INSTANCE = new DeleteUserCommand();

    private final UserMethods userMethods = UserMethods.getInstance();

    private DeleteUserCommand(){}

    public static Command getInstance(){return INSTANCE;}
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        userMethods.deleteUser(id);

        List<User> listOrders = userMethods.findAllUsers();
        request.setAttribute("usersArray", listOrders);

        return "usersAdmin.jsp";
    }
}
