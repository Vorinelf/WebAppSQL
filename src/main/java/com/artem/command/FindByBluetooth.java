package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindByBluetooth implements Command {
    private static final Command INSTANCE = new FindByBluetooth();
    AllMethodsDataBase allMethodsDataBase = new AllMethodsDataBase();

    private FindByBluetooth() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
            String blue = request.getParameter("blue");
            List<Headphones> listHeadphones = allMethodsDataBase.findByBlue(blue);
            request.setAttribute("headphonesArray", listHeadphones);
            return "new.jsp";
        }
    }

