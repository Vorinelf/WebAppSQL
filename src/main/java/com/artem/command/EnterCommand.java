package com.artem.command;

import com.artem.methods.AllMethodsBathroom;

import javax.servlet.http.HttpServletRequest;

public class EnterCommand implements Command {
    private static final Command INSTANCE = new EnterCommand();
    private final AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();
    private EnterCommand() {}
    public static Command getInstance () {return INSTANCE;}

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
