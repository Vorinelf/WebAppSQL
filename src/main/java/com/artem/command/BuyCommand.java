package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.HeadphonesMethods;
import com.artem.methods.OrderMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BuyCommand implements Command {
    private static final Command INSTANCE = new BuyCommand();
    OrderMethods orderMethods = OrderMethods.getInstance();

    private BuyCommand(){}

    public static Command getInstance() {return INSTANCE;}

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Headphones> listHeadphones = (List<Headphones>) session.getAttribute("cart");
        User user = (User) session.getAttribute("userOrder");
        orderMethods.saveOrderInBase(listHeadphones,user);

        return "buyOk.jsp";
    }
}
