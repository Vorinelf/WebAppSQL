package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindByPriceCommand implements Command{
    private static final Command INSTANCE = new FindByPriceCommand();

    AllMethodsDataBase allMethodsDataBase = new AllMethodsDataBase();

    private FindByPriceCommand() {
    }


    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int priceFrom = Integer.parseInt(request.getParameter("priceFrom"));
        int priceTo = Integer.parseInt(request.getParameter("priceTo"));
        List<Headphones> listHeadphones = allMethodsDataBase.findByPrice(priceFrom,priceTo);
        request.setAttribute("headphonesArray", listHeadphones);
        return "new.jsp";
    }
}
