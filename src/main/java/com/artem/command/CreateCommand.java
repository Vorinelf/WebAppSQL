package com.artem.command;

import com.artem.device.BathroomDevice;
import com.artem.methods.AllMethodsBathroom;

import javax.servlet.http.HttpServletRequest;

public class CreateCommand implements Command {
    private static final Command INSTANCE = new CreateCommand();
    private final AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();

    private CreateCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }
    @Override
    public String execute(HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            int id = Integer.parseInt(request.getParameter("id"));
            int powerSizekW = Integer.parseInt(request.getParameter("powerSizekW"));
            boolean powerON = Boolean.parseBoolean(request.getParameter("powerON"));
            boolean waterproof = Boolean.parseBoolean(request.getParameter("waterproof"));
            BathroomDevice bathroomDevice = new BathroomDevice(id, name, powerSizekW, powerON, waterproof);
            AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();
            allMethodsBathroom.create(bathroomDevice);
            return "/selectBathroom";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "/createBathroom.jsp";
        }

    }
}
