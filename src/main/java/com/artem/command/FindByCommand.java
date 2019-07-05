package com.artem.command;

import com.artem.headphones.Headphones;
import com.artem.methods.HeadphonesMethods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.stream.Collectors;

public class FindByCommand implements Command {
    private static final Command INSTANCE = new FindByCommand();

    HeadphonesMethods headphonesMethods = HeadphonesMethods.getInstance();

    private FindByCommand() {
    }


    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String column = request.getParameter("column");
        String param = request.getParameter("param");
        List<Headphones> listHeadphones = headphonesMethods.findBy(column, param);
        request.setAttribute("headphonesArray", listHeadphones);

        HttpSession session = request.getSession(true);
        String pageFoRole = (String) session.getAttribute("pageFoRole");

        session.setAttribute("headphonesArray", listHeadphones);

        return pageFoRole;
    }

    public List<Headphones> sortByNameStream(String name, List<Headphones> listHeadphones) {
        return listHeadphones
                .stream()
                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList());
    }

    List<Headphones> addHeadphonesInFinalFilter(List<Headphones> fromList, List<Headphones> inList) {
        for (Headphones hd : fromList) {
            int id = hd.getId();
            String name = hd.getName();
            String model = hd.getModel();
            int price = hd.getPrice();
            String construction = hd.getConstruction();
            String hiRes = hd.getHiRes();
            String bluetooth = hd.getBluetooth();
            int release = hd.getRelease();
            String stock = hd.getStock();
            Headphones headphones = new Headphones(id, name, model, price, construction, hiRes, bluetooth, release, stock);
            inList.add(headphones);
        }
        return inList;
    }
}

