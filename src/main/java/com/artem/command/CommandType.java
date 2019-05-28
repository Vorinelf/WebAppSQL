package com.artem.command;

import java.util.Arrays;

public enum  CommandType {
    CREATE(CreateCommand.getInstance()),
    EDIT_READ (EditReadCommand.getInstance()),
    EDIT_WRITE(EditWriteCommand.getInstance()),
    DELETE(DeleteCommand.getInstance()),
    FIND_ALL(FindAllCommand.getInstance()),
    REGISTRATION(RegistrationCommand.getInstance()),
    LOGIN(LoginCommand.getInstance());

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
