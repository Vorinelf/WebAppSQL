package com.artem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artem.methods.AllMethodsBathroom;
import com.artem.device.BathroomDevice;

@WebServlet("/selectBathroom")
public class SelectServletBathroom extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<BathroomDevice> bathroomDeviceArrayServ;

        AllMethodsBathroom allMethodsBathroom = new AllMethodsBathroom();
        bathroomDeviceArrayServ = allMethodsBathroom.findAll();
        request.setAttribute("bathroomDeviceArrayServ", bathroomDeviceArrayServ);
        getServletContext().getRequestDispatcher("/mainBathroom.jsp").forward(request, response);

    }

}
