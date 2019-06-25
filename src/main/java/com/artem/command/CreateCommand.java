package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreateCommand implements Command {
    private static final Command INSTANCE = new CreateCommand();
    private final AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private CreateCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String model = request.getParameter("model");
        int price = Integer.parseInt(request.getParameter("price"));
        String construction = request.getParameter("construction");
        String hiRes = request.getParameter("hiRes");
        String bluetooth = request.getParameter("bluetooth");
        int release = Integer.parseInt(request.getParameter("release"));
        String stock = request.getParameter("stock");

        Headphones headphones= new Headphones(name, model,price, construction,hiRes,bluetooth,release,stock);
        allMethodsDataBase.create(headphones);
        List<Headphones> listHeadphones = allMethodsDataBase.findAll();
        request.setAttribute("headphonesArray",listHeadphones);
        return "new.jsp";

    }

}

