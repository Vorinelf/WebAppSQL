package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.HeadphonesMethods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FindAllCommand implements Command {
    private static final Command INSTANCE = new FindAllCommand();
    private final HeadphonesMethods headphonesMethods = HeadphonesMethods.getInstance();

    private FindAllCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        List<Headphones> listHd;
        HttpSession session = request.getSession();
        listHd = (List<Headphones>) session.getAttribute("headphonesArray");
        if (listHd != null) {
            listHd = null;
        }
        session.setAttribute("headphonesArray", listHd);

        List<Headphones> list = (List<Headphones>) session.getAttribute("cart");
        if (list != null) {
            session.setAttribute("sizeOfCart", list.size());
        }

        List<Headphones> listHeadphones = headphonesMethods.findAll();
        request.setAttribute("headphonesArray", listHeadphones);

        page = (String) session.getAttribute("pageFoRole");


        return page;
    }
}
