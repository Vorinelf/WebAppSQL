package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.HeadphonesMethods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FindByPriceCommand implements Command {
    private static final Command INSTANCE = new FindByPriceCommand();

    HeadphonesMethods headphonesMethods = HeadphonesMethods.getInstance();

    private FindByPriceCommand() {
    }


    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int priceFrom = Integer.parseInt(request.getParameter("priceFrom"));
        int priceTo = Integer.parseInt(request.getParameter("priceTo"));
        List<Headphones> listHeadphones = headphonesMethods.findByPrice(priceFrom, priceTo);
        HttpSession session = request.getSession(true);
        session.setAttribute("headphonesArray", listHeadphones);
        request.setAttribute("headphonesArray", listHeadphones);

        String pageFoRole = (String) session.getAttribute("pageFoRole");

        return pageFoRole;
    }
}
