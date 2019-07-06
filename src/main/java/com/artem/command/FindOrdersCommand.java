package com.artem.command;

import com.artem.methods.OrderMethods;
import com.artem.order.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindOrdersCommand implements Command {

    private final static Command INSTANCE = new FindOrdersCommand();
    private final OrderMethods orderMethods = OrderMethods.getInstance();

    public static Command getInstance() {
        return INSTANCE;
    }


    @Override
    public String execute(HttpServletRequest request) {
        String page;

        List<Order> listOrders = orderMethods.findAllOrders();

        if (listOrders.size() == 0) {
            page = "ordersAdminEmpty.jsp";
        } else {
            page = "ordersAdmin.jsp";
            request.setAttribute("ordersArray", listOrders);
        }

        return page;
    }
}
