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
    private List<Headphones> listHeadphones;

    public static Command getInstance() {
        return INSTANCE;
    }

    private InCartCommand() {
    }


    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Headphones headphones = allMethodsDataBase.findEntityById(id);
        HttpSession session = request.getSession(true);
        listHeadphones = (List<Headphones>) session.getAttribute("cart");
        if (listHeadphones == null) {
            listHeadphones = new ArrayList<>();
           listHeadphones.add(headphones);
            session.setAttribute("cart", listHeadphones);
            session.setAttribute("sizeOfCart",listHeadphones.size());

        } else {
            listHeadphones.add(headphones);
            List<Headphones> listHeadphonesSorted = listHeadphones
                    .stream()
                    .sorted(Comparator.comparing(Headphones::getId))
                    .collect(Collectors.toList());
            session.setAttribute("cart", listHeadphonesSorted);
            session.setAttribute("sizeOfCart",listHeadphonesSorted.size());
        }

        List<Headphones> listHeadphones = (List<Headphones>) session.getAttribute("headphonesArray");
        request.setAttribute("headphonesArray",listHeadphones);
        return "new.jsp";
    }

}

