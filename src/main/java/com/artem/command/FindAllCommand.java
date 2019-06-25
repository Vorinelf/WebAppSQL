package com.artem.command;

import com.artem.filter.ClientType;
import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FindAllCommand implements Command {
    private static final Command INSTANCE = new FindAllCommand();
    private final AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private FindAllCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        List<Headphones> list = (List<Headphones>) session.getAttribute("cart");
        if (list != null) {
            session.setAttribute("sizeOfCart", list.size());
        }
        ClientType clientType = (ClientType) session.getAttribute("role");
        List<Headphones> listHeadphones = allMethodsDataBase.findAll();
        session.setAttribute("headphonesArray",listHeadphones);
        if (clientType == ClientType.ADMIN) {
            page = "headphonesAdmin.jsp";
        } else {
            page = "new.jsp";
        }

        return page;
    }
}
