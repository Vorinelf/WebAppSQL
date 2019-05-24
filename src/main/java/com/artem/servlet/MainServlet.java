package com.artem.servlet;

import com.artem.command.Command;
import com.artem.command.CommandType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void  processRequest (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nameCommand = req.getParameter("command");
        Command command = CommandType.findCommand(nameCommand);
        String page = command.execute(req);
        resp.sendRedirect(req.getContextPath() + page);
      //req.getRequestDispatcher(page).forward(req,resp);

    }
}
