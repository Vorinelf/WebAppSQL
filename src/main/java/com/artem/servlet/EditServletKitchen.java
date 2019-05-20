package com.artem.servlet;
import com.artem.device.KitchenDevice;
import com.artem.db.KitchenDeviceDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editKitchen")
public class EditServletKitchen extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            KitchenDevice kitchenDevice = KitchenDeviceDB.getKitchenDeviceDB().selectOneKitchenDevice(id);
            if(kitchenDevice!=null) {
                request.setAttribute("kitchenDevice", kitchenDevice);
                getServletContext().getRequestDispatcher("/editKitchen.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int powerSizekW = Integer.parseInt(request.getParameter("powerSizekW"));
            boolean powerON = Boolean.parseBoolean(request.getParameter("powerON"));
            int minTemperature = Integer.parseInt(request.getParameter("minTemperature"));
            int maxTemperature = Integer.parseInt(request.getParameter("maxTemperature"));

            KitchenDevice kitchenDevice = new KitchenDevice(id,name,powerSizekW,powerON,minTemperature,maxTemperature);
            KitchenDeviceDB.getKitchenDeviceDB().update(kitchenDevice);
            response.sendRedirect(request.getContextPath()+"/selectKitchen");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}