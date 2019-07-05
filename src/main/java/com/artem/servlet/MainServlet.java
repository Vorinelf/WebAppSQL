package com.artem.servlet;

import com.artem.command.Command;
import com.artem.command.CommandType;
import com.artem.session.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookies.setCookie(resp);
        processRequest(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameCommand = req.getParameter("command");
        Command command = CommandType.findCommand(nameCommand);
        String page = command.execute(req);
        if (page == null) {
            page = "index.jsp";
        }
        req.getRequestDispatcher(page).forward(req, resp);
    }
}

