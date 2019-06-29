package com.artem.command;

import com.artem.device.BathroomDevice;
import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;

public class EditReadCommand implements Command {
    private static final Command INSTANCE = new EditReadCommand();
    private final AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private EditReadCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Headphones headphones = allMethodsDataBase.findEntityById(id);
        if (headphones != null) {
            request.setAttribute("headphones", headphones);
        }
        return "editHeadphones.jsp";
    }
}
