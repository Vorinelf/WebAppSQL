package com.artem.command;

import com.artem.filter.ClientType;
import com.artem.methods.UserMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegistrationCommand implements Command {
    private static final Command INSTANCE = new RegistrationCommand();
    private final UserMethods userMethods = UserMethods.getInstance();

    private RegistrationCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;

        String isAdmin = request.getParameter("isAdmin");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String postIndex = request.getParameter("postIndex");
        String phone = request.getParameter("phone");

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] byteData = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte newByte : byteData) {
            sb.append(Integer.toString((newByte & 0xff) + 0x100, 16).substring(1));
        }

        String passwordCipher = sb.toString();

        User userAfterCheck = userMethods.checkLoginOrNewUser(login, passwordCipher);

        if (userAfterCheck != null) {
            page = "registrationError.jsp";
        } else {
            User user = new User(isAdmin, login, passwordCipher, firstName, secondName, country, city, street, postIndex, phone);
            userMethods.registration(user);
            request.setAttribute("user", user);

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);

            session.setAttribute("loginForOrder", login);
            session.setAttribute("passwordForOrder", passwordCipher);

            ClientType clientType = ClientType.USER;
            session.setAttribute("role", clientType);

            session.setAttribute("cart", null);
            session.setAttribute("sizeOfCart", null);

            String pageForRole = "indexUser.jsp";
            session.setAttribute("pageFoRole", pageForRole);

            page = "registrationOk.jsp";
        }
        return page;
    }
}
