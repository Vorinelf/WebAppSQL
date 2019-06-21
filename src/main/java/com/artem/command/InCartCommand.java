package com.artem.command;


import com.artem.device.BathroomDevice;
import com.artem.methods.AllMethodsBathroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InCartCommand implements Command {
    private static final Command INSTANCE = new InCartCommand();
    private final AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();
    private List<BathroomDevice> listBathroomDevices;

    public static Command getInstance() {
        return INSTANCE;
    }

    private InCartCommand() {
    }


    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        BathroomDevice bathroomDevice = allMethodsBathroom.findEntityById(id);
        HttpSession session = request.getSession(true);
        listBathroomDevices = (List) session.getAttribute("cart");
        if (listBathroomDevices == null) {
            listBathroomDevices = new ArrayList<>();
            listBathroomDevices.add(bathroomDevice);
            session.setAttribute("cart", listBathroomDevices);
            session.setAttribute("sizeOfCart",listBathroomDevices.size());

        } else {
            listBathroomDevices.add(bathroomDevice);
            List<BathroomDevice> listBathroomSorted = listBathroomDevices
                    .stream()
                    .sorted(Comparator.comparing(BathroomDevice::getId))
                    .collect(Collectors.toList());
            session.setAttribute("cart", listBathroomSorted);
            session.setAttribute("sizeOfCart",listBathroomSorted.size());
        }
        List<BathroomDevice> listBathroom = allMethodsBathroom.findAll();
        request.setAttribute("bathroomDeviceArray", listBathroom);
        return "mainBathroomFree.jsp";
    }

}

