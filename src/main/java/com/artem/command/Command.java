package com.artem.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    String execute (HttpServletRequest httpServletRequest);
}
