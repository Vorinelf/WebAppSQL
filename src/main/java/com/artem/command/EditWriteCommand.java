package com.artem.command;

import com.artem.device.BathroomDevice;
import com.artem.methods.AllMethodsBathroom;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditWriteCommand implements Command {
    private static final Command INSTANCE = new EditWriteCommand();
    private final AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();

    private EditWriteCommand() {
    }

    public static Command getInstance() {return INSTANCE;}

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int powerSizekW = Integer.parseInt(request.getParameter("powerSizekW"));
        boolean powerON = Boolean.parseBoolean(request.getParameter("powerON"));
        boolean waterproof = Boolean.parseBoolean(request.getParameter("waterproof"));

        BathroomDevice bathroomDevice = new BathroomDevice(id, name, powerSizekW, powerON, waterproof);
        allMethodsBathroom.update(bathroomDevice);

        List<BathroomDevice> listBathroom = allMethodsBathroom.findAll();
        request.setAttribute("bathroomDeviceArray", listBathroom);
        return "mainBathroom.jsp";
    }
}
