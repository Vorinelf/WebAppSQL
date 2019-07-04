package com.artem.command;

import com.artem.filter.ClientType;
import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LogoutCommand implements Command {
    private static final Command INSTANCE = new LogoutCommand();
    private final AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private LogoutCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }


    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        ClientType clientType = ClientType.GUEST;
        session.setAttribute("role", clientType);
        session.setAttribute("cart", null);
        session.setAttribute("pageFoRole", null);
        session.setAttribute("loginForOrder", null);
        session.setAttribute("passwordForOrder", null);
        session.setAttribute("sizeOfCart", null);

        List<Headphones> listHeadphones = allMethodsDataBase.findAll();
        request.setAttribute("headphonesArray", listHeadphones);

        return "index.jsp";
    }
}
