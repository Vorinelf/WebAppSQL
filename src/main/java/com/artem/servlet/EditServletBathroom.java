//package com.artem.servlet;
//
//import com.artem.methods.AllMethodsDataBase;
//import com.artem.device.BathroomDevice;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@WebServlet("/editBathroom")
//public class EditServletBathroom extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            int id = Integer.parseInt(request.getParameter("id"));
//            AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();
//            BathroomDevice bathroomDevice = allMethodsDataBase.findEntityById(id);
//            if (bathroomDevice != null) {
//                request.setAttribute("bathroomDevice", bathroomDevice);
//                getServletContext().getRequestDispatcher("/editHeadphones.jsp").forward(request, response);
//            } else {
//                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
//            }
//        } catch (Exception ex) {
//            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            int id = Integer.parseInt(request.getParameter("id"));
//            String name = request.getParameter("name");
//            int powerSizekW = Integer.parseInt(request.getParameter("powerSizekW"));
//            boolean powerON = Boolean.parseBoolean(request.getParameter("powerON"));
//            boolean waterproof = Boolean.parseBoolean(request.getParameter("waterproof"));
//
//            BathroomDevice bathroomDevice = new BathroomDevice(id, name, powerSizekW, powerON, waterproof);
//            AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();
//            allMethodsDataBase.update(bathroomDevice);
//            response.sendRedirect(request.getContextPath() + "/selectBathroom");
//        } catch (Exception ex) {
//
//            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
//        }
//    }
//}