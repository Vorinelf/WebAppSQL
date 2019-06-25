package com.artem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artem.methods.AllMethodsDataBase;
import com.artem.device.BathroomDevice;

@WebServlet("/selectBathroom")
public class SelectServletBathroom extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<BathroomDevice> bathroomDeviceArrayServ;

        AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();
     //   bathroomDeviceArrayServ = allMethodsDataBase.findAll();
      //  request.setAttribute("bathroomDeviceArray", bathroomDeviceArrayServ);
        getServletContext().getRequestDispatcher("/headphonesAdmin.jsp").forward(request, response);

    }

}
