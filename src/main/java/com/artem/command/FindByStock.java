package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindByStock implements Command{
    private static final Command INSTANCE = new FindByStock();
    AllMethodsDataBase allMethodsDataBase = new AllMethodsDataBase();
    public static Command getInstance(){return INSTANCE;}

    @Override
    public String execute(HttpServletRequest request) {
            String stock = request.getParameter("stock");
            List<Headphones> listHeadphones = allMethodsDataBase.findByStock(stock);
            request.setAttribute("headphonesArray", listHeadphones);
            return "new.jsp";
}
}
