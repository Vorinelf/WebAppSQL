package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FindByConstructionCommand implements Command {
    private static final Command INSTANCE = new FindByConstructionCommand();

    AllMethodsDataBase allMethodsDataBase =AllMethodsDataBase.getInstance();

    private FindByConstructionCommand() {
    }


    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String construction = request.getParameter("constr");
        List<Headphones> listHeadphones = allMethodsDataBase.findByConstruction(construction);
        HttpSession session = request.getSession(true);
        session.setAttribute("headphonesArray", listHeadphones);
        request.setAttribute("headphonesArray", listHeadphones);
        return "new.jsp";
    }
}
