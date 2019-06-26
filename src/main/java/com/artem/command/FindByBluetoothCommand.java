package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.AllMethodsDataBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindByBluetoothCommand implements Command {
    private static final Command INSTANCE = new FindByBluetoothCommand();
    AllMethodsDataBase allMethodsDataBase = AllMethodsDataBase.getInstance();

    private FindByBluetoothCommand() {
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

