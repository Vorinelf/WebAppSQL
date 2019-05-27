package com.artem.command;

import com.artem.device.BathroomDevice;
import com.artem.methods.AllMethodsBathroom;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteCommand implements Command {
    private final static Command INSTANCE = new DeleteCommand();
    private final AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();

    private DeleteCommand() {}

    public static Command getInstance(){return INSTANCE;}

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        allMethodsBathroom.delete(id);

        List<BathroomDevice> listBathroom = allMethodsBathroom.findAll();
        request.setAttribute("bathroomDeviceArray", listBathroom);
        return "mainBathroom.jsp";
    }
}
