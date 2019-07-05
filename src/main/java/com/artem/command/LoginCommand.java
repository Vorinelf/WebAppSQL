package com.artem.command;

import com.artem.filter.ClientType;
import com.artem.headphones.Headphones;
import com.artem.methods.HeadphonesMethods;
import com.artem.methods.UserMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class LoginCommand implements Command {
    private static final Command INSTANCE = new LoginCommand();
    private final UserMethods userMethods = UserMethods.getInstance();
    private final HeadphonesMethods headphonesMethods = HeadphonesMethods.getInstance();

    private LoginCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession(true);
        session.setAttribute("cart", null);
        session.setAttribute("sizeOfCart", null);
        ClientType clientType;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
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
        User user = userMethods.checkLoginOrNewUser(login, passwordCipher);

        if (user != null) {
            session.setAttribute("loginForOrder", login);
            session.setAttribute("passwordForOrder", passwordCipher);
            if (user.isAdmin()) {
                clientType = ClientType.ADMIN;
                session.setAttribute("role", clientType);
                String pageForRole = "indexAdmin.jsp";
                session.setAttribute("pageFoRole", pageForRole);
            } else {
                clientType = ClientType.USER;
                session.setAttribute("role", clientType);
                String pageForRole = "indexUser.jsp";
                session.setAttribute("pageFoRole", pageForRole);
            }
            session.setAttribute("user", user);
            page = (String) session.getAttribute("pageFoRole");
        } else {
            page = "loginError.jsp";
        }

        List<Headphones> listHeadphones = headphonesMethods.findAll();
        request.setAttribute("headphonesArray", listHeadphones);

        return page;
    }
}
