package com.artem.command;

import com.artem.headphones.Headphones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DeleteFromCartCommand implements Command {
    private static final Command INSTANCE = new DeleteFromCartCommand();

    private DeleteFromCartCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession(true);
        List<Headphones> cartList = (List<Headphones>) session.getAttribute("cart");
        Headphones headphones = cartList
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
        cartList.remove(headphones);
        session.setAttribute("cart", cartList);

        return "cart.jsp";
    }
}
