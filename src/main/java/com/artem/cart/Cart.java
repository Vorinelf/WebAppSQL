package com.artem.cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Cart extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String s, goods[] = {"Fifa 15", "Battlefield 5", "GTA 6"}; ******price []={
//            10, 20, 30
//        } ; ******cost;
//        PrintWriter out = res.getWriter();
//        res.setContentType("text/html");
//        HttpSession session = req.getSession(true);
//        if (session == null) return;
//        for (int i = 0; i < goods.length; i++)
//            if (session.getAttribute(goods[i]) == null) session.setAttribute(goods[i], new Integer(0));
//        if ((s = req.getParameter("buy")) != null) {
//            int n = ((Integer) session.getAttribute(s)).intValue();
//            session.setAttribute(s, new Integer(n + 1));
//        }
//        out.println("<h2>Shopping Cart</h2><ul>");
//        for (int i = 0; i < goods.length; i++) {
//            int n = ((Integer) session.getAttribute(goods[i])).intValue();
//            if (n > 0) {
//                out.println("<li><b>" + goods[i] + "</b> : " + n + ":" + price[i] + "</li>");
//                cost = n * price[i];
//                out.println(cost);
//            }
//        }
//        out.println("</ul>");
//    }
}}

