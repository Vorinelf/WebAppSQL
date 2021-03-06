package com.artem.command;

import java.util.Arrays;

public enum CommandType {
    CREATE(CreateCommand.getInstance()),
    EDIT_READ(EditReadCommand.getInstance()),
    EDIT_WRITE(EditWriteCommand.getInstance()),
    DELETE(DeleteCommand.getInstance()),
    FIND_ALL(FindAllCommand.getInstance()),
    REGISTRATION(RegistrationCommand.getInstance()),
    IN_CART(InCartCommand.getInstance()),
    LOGIN(LoginCommand.getInstance()),
    DELETE_FROM_CART(DeleteFromCartCommand.getInstance()),
    FIND_BY(FindByCommand.getInstance()),
    FIND_BY_PRICE(FindByPriceCommand.getInstance()),
    SORT_BY_PRICE(SortByPriceCommand.getInstance()),
    SORT_BY(SortByCommand.getInstance()),
    ORDER(OrderCommand.getInstance()),
    BUY(BuyCommand.getInstance()),
    CHECK_CART(CheckCartCommand.getInstance()),
    LOGOUT(LogoutCommand.getInstance()),
    FIND_ORDERS(FindOrdersCommand.getInstance()),
    FIND_USERS(FindUsersCommand.getInstance()),
    DELETE_ORDER(DeleteOrderCommand.getInstance()),
    DELETE_ALL_ORDERS(DeleteAllOrdersCommand.getInstance()),
    DELETE_USER(DeleteUserCommand.getInstance()),
    ADD_ADMIN(AddAdminCommand.getInstance());


    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public static Command findCommand(String name) {
        return Arrays.stream(CommandType.values())
                .filter(type -> type.name().toLowerCase().equals(name))
                .map(type -> type.command)
                .findAny()
                .orElse(getDefault());
    }


    public static Command getDefault() {
        return FIND_ALL.command;
    }

}
