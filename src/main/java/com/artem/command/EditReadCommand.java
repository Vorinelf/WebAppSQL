package com.artem.command;

import com.artem.device.BathroomDevice;
import com.artem.methods.AllMethodsBathroom;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditReadCommand implements Command {
    private static final Command INSTANCE = new EditReadCommand();
    private final AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();

    private EditReadCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        BathroomDevice bathroomDevice = allMethodsBathroom.findEntityById(id);
        if (bathroomDevice != null) {
            request.setAttribute("bathroomDevice", bathroomDevice);
        }
        return "editBathroom.jsp";
    }
}
