package com.artem.command;

import com.artem.device.BathroomDevice;
import com.artem.methods.AllMethodsBathroom;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindAllCommand implements Command{
    private static final Command INSTANCE = new FindAllCommand();
    private final AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();
    private FindAllCommand(){}

    public static Command getInstance() {return INSTANCE;}

    @Override
    public String execute(HttpServletRequest request) {
        List<BathroomDevice> listBathroom = allMethodsBathroom.findAll();
        request.setAttribute("bathroomDeviceArray", listBathroom);
        return "mainBathroom.jsp";
    }
}
