package com.artem.command;

import com.artem.filter.ClientType;
import com.artem.methods.UserMethods;
import com.artem.users.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AddAdminCommand implements Command {

    private static final Command INSTANCE =new AddAdminCommand();

    private final UserMethods userMethods = UserMethods.getInstance();

    private AddAdminCommand(){}

    public static Command getInstance(){return INSTANCE;}

    @Override
    public String execute(HttpServletRequest request) {

        String page;

        String isAdmin = request.getParameter("isAdmin");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String emptyFild = "0";



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
            page = "registrationAdminError.jsp";
        } else {
            User user = new User(isAdmin, login, passwordCipher, firstName, secondName, emptyFild, emptyFild, emptyFild, emptyFild, emptyFild);
            userMethods.registration(user);

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);


            ClientType clientType = ClientType.ADMIN;
            session.setAttribute("role", clientType);


            String pageForRole = "indexAdmin.jsp";
            session.setAttribute("pageFoRole", pageForRole);

            List<User> listOrders = userMethods.findAllUsers();
            request.setAttribute("usersArray", listOrders);

            page = "usersAdmin.jsp";
        }
        return page;
    }
}
