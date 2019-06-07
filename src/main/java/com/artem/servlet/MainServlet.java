package com.artem.servlet;

import com.artem.command.Command;
import com.artem.command.CommandType;
import com.artem.filter.ClientType;
import com.artem.filter.FilterController;
import com.artem.session.Cookies;
import com.artem.session.SessionLocator;
import com.artem.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
        req.getRequestDispatcher(page).forward(req, resp);
        req.setAttribute("messagesCookie", Cookies.addToRequest(req));
        System.out.println(Cookies.addToRequest(req));


//        HttpSession session;
//        if (SessionLocator.flag) {
//            session = req.getSession();
//            session.setMaxInactiveInterval(20);
//            SessionLocator.flag = false;
//
//        } else {
//            session = req.getSession(false);
//            if (session == null) {
//                SessionLocator.flag = true;
//            }
//        }
//
//        Integer count = (Integer) session.getAttribute("count");
//        if (count == null) {
//            session.setAttribute("count", 1);
//        } else {
//            session.setAttribute("count", count + 1);
//        }
//
//
//
//        session.setAttribute("messages", SessionLocator.addMessage(session));
    }
}
