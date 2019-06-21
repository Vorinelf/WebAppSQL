package com.artem.command;

import com.artem.device.BathroomDevice;
import com.artem.methods.AllMethodsBathroom;

import javax.crypto.IllegalBlockSizeException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeleteFromCartCommand implements Command {
    private static final Command INSTANCE = new DeleteFromCartCommand();
    private final AllMethodsBathroom allMethodsBathroom = new AllMethodsBathroom();
    List<BathroomDevice> cartList;
    private DeleteFromCartCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession(true);
        cartList = (List<BathroomDevice>) session.getAttribute("cart");
        BathroomDevice bathroomDevice = cartList
                .stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .get();
        cartList.remove(bathroomDevice);
        session.setAttribute("cart",cartList);
        return "cart.jsp";
    }
}
