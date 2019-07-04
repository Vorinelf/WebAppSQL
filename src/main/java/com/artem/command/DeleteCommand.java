package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DeleteCommand implements Command {
    private final static Command INSTANCE = new DeleteCommand();
    private final AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private DeleteCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        allMethodsDataBase.delete(id);

        List<Headphones> listHeadphones = allMethodsDataBase.findAll();
        request.setAttribute("headphonesArray", listHeadphones);

        HttpSession session = request.getSession(true);
        String pageFoRole = (String) session.getAttribute("pageFoRole");

        return pageFoRole;
    }
}
