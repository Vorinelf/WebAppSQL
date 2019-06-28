package com.artem.command;

import java.util.Arrays;

public enum  CommandType {
    CREATE(CreateCommand.getInstance()),
    EDIT_READ(EditReadCommand.getInstance()),
    EDIT_WRITE(EditWriteCommand.getInstance()),
    DELETE(DeleteCommand.getInstance()),
    FIND_ALL(FindAllCommand.getInstance()),
    REGISTRATION(RegistrationCommand.getInstance()),
    IN_CART(InCartCommand.getInstance()),
    LOGIN(LoginCommand.getInstance()),
    DELETE_FROM_CART(DeleteFromCartCommand.getInstance()),
    FIND_BY_NAME(FindByBrandCommand.getInstance()),
    FIND_BY_PRICE(FindByPriceCommand.getInstance()),
    FIND_BY_CONSTRUCTION(FindByConstructionCommand.getInstance()),
    FIND_BY_HIRES(FindByHiResCommand.getInstance()),
    FIND_BY_BLUE(FindByBluetoothCommand.getInstance()),
    FIND_BY_STOCK(FindByStockCommand.getInstance()),
    SORT_BY_PRICE(SortByPriceCommand.getInstance()),
    SORT_BY(SortByCommand.getInstance()),
    ORDER(OrderCommand.getInstance());

    private Command command;

    CommandType (Command command) {this.command = command;}
    public static Command findCommand (String name) {
        return Arrays.stream(CommandType.values())
                .filter(type->type.name().toLowerCase().equals(name))
                .map(type->type.command)
                .findAny()
                .orElse(getDefault());
    }


    public static Command getDefault () {return FIND_ALL.command;}

}
