package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BuyCommand implements Command {
    private static final Command INSTANCE = new BuyCommand();
    AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private BuyCommand(){}

    public static Command getInstance() {return INSTANCE;}

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Headphones> listHeadphones = (List<Headphones>) session.getAttribute("cart");
        User user = (User) session.getAttribute("userOrder");
        allMethodsDataBase.saveOrderInBase(listHeadphones,user);

        return "buyOk.jsp";
    }
}
