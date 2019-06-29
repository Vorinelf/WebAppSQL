package com.artem.command;

import com.artem.headphones.Headphones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CheckCartCommand implements Command {
    private static final Command INSTANCE = new CheckCartCommand();

    private CheckCartCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession(true);
        List<Headphones> list = (List<Headphones>) session.getAttribute("cart");
        if (list != null) {
            page = "cart.jsp";
        } else {
            page = "cartEmpty.jsp";
        }
        return page;
    }
}
