package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.HeadphonesMethods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.stream.Collectors;

public class FindByCommand implements Command {
    private static final Command INSTANCE = new FindByCommand();

    HeadphonesMethods headphonesMethods = HeadphonesMethods.getInstance();

    private FindByCommand() {
    }


    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String column = request.getParameter("column");
        String param = request.getParameter("param");

        List<Headphones> listHeadphones = headphonesMethods.findBy(column, param);
        request.setAttribute("headphonesArray", listHeadphones);

        HttpSession session = request.getSession(true);
        String pageFoRole = (String) session.getAttribute("pageFoRole");

        session.setAttribute("headphonesArray", listHeadphones);

        return pageFoRole;
    }
}

