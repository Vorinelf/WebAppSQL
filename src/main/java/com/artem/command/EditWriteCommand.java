package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class EditWriteCommand implements Command {
    private static final Command INSTANCE = new EditWriteCommand();
    private final AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private EditWriteCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String model = request.getParameter("model");
        int price = Integer.parseInt(request.getParameter("price"));
        String construction = request.getParameter("construction");
        String hiRes = request.getParameter("hiRes");
        String bluetooth = request.getParameter("bluetooth");
        int release = Integer.parseInt(request.getParameter("release"));
        String stock = request.getParameter("stock");

        Headphones headphones = new Headphones(id, name, model, price, construction, hiRes, bluetooth, release, stock);
        allMethodsDataBase.update(headphones);

        List<Headphones> listHeadphones = allMethodsDataBase.findAll();
        request.setAttribute("headphonesArray", listHeadphones);

        HttpSession session =request.getSession(true);
        String pageFoRole = (String) session.getAttribute("pageFoRole");

        return pageFoRole;
    }
}
