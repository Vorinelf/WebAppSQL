package com.artem.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artem.device.KitchenDevice;
import com.artem.DB.KitchenDeviceDB;

@WebServlet("/selectKitchen")
public class SelectServletKitchen extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<KitchenDevice> kitchenDevicesArrayServ = KitchenDeviceDB.selectKitchenDevice();
        request.setAttribute("kitchenDevicesArrayServ", kitchenDevicesArrayServ);
        getServletContext().getRequestDispatcher("/mainKitchen.jsp").forward(request, response);
    }
}