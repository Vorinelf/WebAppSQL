package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByPriceCommand implements Command {
    private static final Command INSTANCE = new SortByPriceCommand();
    AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private SortByPriceCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Headphones> list = (List<Headphones>) session.getAttribute("headphonesArray");
        String highOrLow = request.getParameter("highOrLow");
        if (list != null) {
            List<Headphones> listSorted;
            String param = "ASC";
            if (highOrLow.equals(param)) {
                listSorted = list.stream()
                        .sorted(Comparator.comparing(Headphones::getPrice).reversed())
                        .collect(Collectors.toList());
            } else {
                listSorted = list.stream()
                        .sorted(Comparator.comparing(Headphones::getPrice))
                        .collect(Collectors.toList());
            }
            session.setAttribute("headphonesArray", listSorted);
        } else {
            String column = request.getParameter("column");
            List<Headphones> listHeadphones = allMethodsDataBase.findAndSortByPrice(column, highOrLow);
            request.setAttribute("headphonesArray", listHeadphones);
        }
        return "new.jsp";
    }
}
