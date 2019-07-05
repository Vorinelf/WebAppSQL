package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.HeadphonesMethods;

import javax.servlet.http.HttpServletRequest;

public class EditReadCommand implements Command {
    private static final Command INSTANCE = new EditReadCommand();
    private final HeadphonesMethods headphonesMethods = HeadphonesMethods.getInstance();

    private EditReadCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Headphones headphones = headphonesMethods.findEntityById(id);
        if (headphones != null) {
            request.setAttribute("headphones", headphones);
        }
        return "editHeadphones.jsp";
    }
}
