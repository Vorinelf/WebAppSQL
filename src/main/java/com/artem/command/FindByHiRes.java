package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindByHiRes implements Command{
    private static final Command INSTANCE = new FindByHiRes();

    AllMethodsDataBase allMethodsDataBase = new AllMethodsDataBase();

    private FindByHiRes() {
    }


    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String hiRes = request.getParameter("hiRes");
        List<Headphones> listHeadphones = allMethodsDataBase.findByHiRes(hiRes);
        request.setAttribute("headphonesArray", listHeadphones);
        return "new.jsp";
    }
}
