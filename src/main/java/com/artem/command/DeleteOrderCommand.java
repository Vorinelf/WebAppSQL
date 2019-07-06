package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.OrderMethods;
import com.artem.order.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteOrderCommand implements Command {
    private static final Command INSTANCE = new DeleteOrderCommand();

    private final OrderMethods orderMethods = OrderMethods.getInstance();

    private DeleteOrderCommand(){}

    public static Command getInstance(){return INSTANCE;}
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        orderMethods.deleteOrder(id);

        List<Order> listOrders = orderMethods.findAllOrders();
        request.setAttribute("ordersArray", listOrders);

        return "ordersAdmin.jsp";
    }
}
