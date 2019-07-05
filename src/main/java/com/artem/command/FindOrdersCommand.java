package com.artem.command;

import javax.servlet.http.HttpServletRequest;

public class FindOrdersCommand implements Command{

    private final static Command INSTANCE = new FindOrdersCommand();


    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
