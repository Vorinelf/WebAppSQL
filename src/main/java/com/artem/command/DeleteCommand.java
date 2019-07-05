package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.HeadphonesMethods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DeleteCommand implements Command {
    private final static Command INSTANCE = new DeleteCommand();
    private final HeadphonesMethods headphonesMethods = HeadphonesMethods.getInstance();

    private DeleteCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        headphonesMethods.delete(id);

        List<Headphones> listHeadphones = headphonesMethods.findAll();
        request.setAttribute("headphonesArray", listHeadphones);

        HttpSession session = request.getSession(true);
        String pageFoRole = (String) session.getAttribute("pageFoRole");

        return pageFoRole;
    }
}
