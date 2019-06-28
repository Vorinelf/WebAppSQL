package com.artem.command;


import com.artem.device.BathroomDevice;
import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InCartCommand implements Command {
    private static final Command INSTANCE = new InCartCommand();
    private final AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();
    private List<Headphones> listHeadphonesCart;

    public static Command getInstance() {
        return INSTANCE;
    }

    private InCartCommand() {
    }


    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession(true);
        Headphones headphones = allMethodsDataBase.findEntityById(id);
        listHeadphonesCart = (List<Headphones>) session.getAttribute("cart");
        if (listHeadphonesCart == null) {
            listHeadphonesCart = new ArrayList<>();
            listHeadphonesCart.add(headphones);
            session.setAttribute("cart", listHeadphonesCart);
            session.setAttribute("sizeOfCart", listHeadphonesCart.size());

        } else {
            listHeadphonesCart.add(headphones);
            List<Headphones> listHeadphonesSorted = listHeadphonesCart
                    .stream()
                    .sorted(Comparator.comparing(Headphones::getId))
                    .collect(Collectors.toList());
            session.setAttribute("cart", listHeadphonesSorted);
            session.setAttribute("sizeOfCart", listHeadphonesSorted.size());
        }
        List<Headphones> list = (List<Headphones>) session.getAttribute("headphonesArray");
        if (list!=null) {
            session.setAttribute("headphonesArray", list);
        } else {
            List<Headphones> listHd = allMethodsDataBase.findAll();
            request.setAttribute("headphonesArray", listHd);
        }
        return "new.jsp";
    }


}

