package com.artem.command;

import com.artem.filter.ClientType;
import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;
import com.artem.session.SessionLocator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        List<Headphones> listHd;
        HttpSession session = request.getSession();
        listHd = (List<Headphones>) session.getAttribute("headphonesArray");
        if (listHd != null) {
            listHd = null;
        }
        session.setAttribute("headphonesArray", listHd);

        List<Headphones> list = (List<Headphones>) session.getAttribute("cart");
        if (list != null) {
            session.setAttribute("sizeOfCart", list.size());
        }

        ClientType clientType = (ClientType) session.getAttribute("role");
        List<Headphones> listHeadphones = allMethodsDataBase.findAll();
        request.setAttribute("headphonesArray", listHeadphones);

        if (clientType == ClientType.ADMIN) {
            page = "headphonesAdmin.jsp";
        } else {
            page = (String) session.getAttribute("pageFoRole");
        }

        return page;
    }
}
