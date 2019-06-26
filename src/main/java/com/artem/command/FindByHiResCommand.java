package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindByHiResCommand implements Command{
    private static final Command INSTANCE = new FindByHiResCommand();

    AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private FindByHiResCommand() {
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
