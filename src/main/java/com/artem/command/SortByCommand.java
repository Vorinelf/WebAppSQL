package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByCommand implements Command {
    private static final Command INSTANCE = new SortByCommand();
    AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private SortByCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List <Headphones> list = (List<Headphones>) session.getAttribute("headphonesArray");
        String column = request.getParameter("column");
        if (list!=null){
            List<Headphones> listSorted;
            if (column.equals("name")) {
                listSorted = list.stream()
                        .sorted(Comparator.comparing(Headphones::getName))
                        .collect(Collectors.toList());
            } else {
                listSorted = list.stream()
                        .sorted(Comparator.comparing(Headphones::getRelease).reversed())
                        .collect(Collectors.toList());
            }
            session.setAttribute("headphonesArray", listSorted);}
            else {
            List<Headphones> listHeadphones = allMethodsDataBase.findAndSortBy(column);
            request.setAttribute("headphonesArray", listHeadphones);
        }
        return "new.jsp";
    }
}
