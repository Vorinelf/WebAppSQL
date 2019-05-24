package com.artem.servlet;

import com.artem.methods.AllMethodsBathroom;
import com.artem.methods.DataBaseHelper;
import com.artem.device.BathroomDevice;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createBathroom")
public class CreateServletBathroom extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/createBathroom.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            int id = Integer.parseInt(request.getParameter("id"));
            int powerSizekW = Integer.parseInt(request.getParameter("powerSizekW"));
            boolean powerON = Boolean.parseBoolean(request.getParameter("powerON"));
            boolean waterproof = Boolean.parseBoolean(request.getParameter("waterproof"));
            BathroomDevice bathroomDevice = new BathroomDevice(id, name, powerSizekW, powerON, waterproof);
            AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();
            allMethodsBathroom.create(bathroomDevice);

            response.sendRedirect(request.getContextPath() + "/selectBathroom");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/createBathroom.jsp").forward(request, response);
        }
    }
}