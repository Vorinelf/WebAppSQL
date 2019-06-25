package com.artem.command;

import com.artem.device.BathroomDevice;
import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DeleteFromCartCommand implements Command {
    private static final Command INSTANCE = new DeleteFromCartCommand();
    private final AllMethodsDataBase allMethodsDataBase = new AllMethodsDataBase();
    List<Headphones> cartList;
    private DeleteFromCartCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession(true);
        cartList = (List<Headphones>) session.getAttribute("cart");
        Headphones headphones = cartList
                .stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .get();
        cartList.remove(headphones);
        session.setAttribute("cart",cartList);
        return "cart.jsp";
    }
}
