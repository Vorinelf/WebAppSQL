package com.artem.command;

import com.artem.device.BathroomDevice;
import com.artem.filter.ClientType;
import com.artem.methods.AllMethodsBathroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FindAllCommand implements Command {
    private static final Command INSTANCE = new FindAllCommand();
    private final AllMethodsBathroom allMethodsBathroom = AllMethodsBathroom.getInstance();

    private FindAllCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        List<BathroomDevice> list = (List<BathroomDevice>) session.getAttribute("cart");
        if (list != null) {
            session.setAttribute("sizeOfCart", list.size());
        }
        ClientType clientType = (ClientType) session.getAttribute("role");
        List<BathroomDevice> listBathroom = allMethodsBathroom.findAll();
        request.setAttribute("bathroomDeviceArray", listBathroom);
        if (clientType == ClientType.ADMIN) {
            page = "mainBathroom.jsp";
        } else {
            page = "new.jsp";
        }

        return page;
    }
}
