package com.artem.command;

import com.artem.methods.OrderMethods;

import javax.servlet.http.HttpServletRequest;

public class DeleteAllOrdersCommand implements Command {

    private static final Command INSTANCE = new DeleteAllOrdersCommand();

    private final OrderMethods orderMethods = OrderMethods.getInstance();

    private DeleteAllOrdersCommand(){}

    public static Command getInstance(){return INSTANCE;}
    @Override
    public String execute(HttpServletRequest request) {

        orderMethods.deleteAllOrders();

        return "ordersAdminEmpty.jsp";
    }
}
