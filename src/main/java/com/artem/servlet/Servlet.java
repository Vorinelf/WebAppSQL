package com.artem.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // ArrayList<> products = ProductDB.select();
       //request.setAttribute("products", products);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
