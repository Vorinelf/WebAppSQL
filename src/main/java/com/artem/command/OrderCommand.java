package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;
import com.artem.methods.LoginMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public class OrderCommand implements Command {
    private static final Command INSTANCE = new OrderCommand();
    AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();
    LoginMethods loginMethods = LoginMethods.getInstance();


    private OrderCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute("loginForOrder");
        String password = (String) session.getAttribute("passwordForOrder");
        User user = loginMethods.checkLoginOrNewUser(login, password);
        session.setAttribute("userOrder", user);

        List<Headphones> list = (List<Headphones>) session.getAttribute("cart");
        int orderCount = list.size();
        int totalSum = list
                .stream().mapToInt(p -> p.getPrice()).sum();
        request.setAttribute("orderCount", orderCount);
        request.setAttribute("totalSum", totalSum);

        return "order.jsp";
    }
}
