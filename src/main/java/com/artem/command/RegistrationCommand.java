package com.artem.command;

import com.artem.methods.LoginMethods;
import com.artem.users.User;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegistrationCommand implements Command {
    private static final Command INSTANCE = new RegistrationCommand();
    private final LoginMethods loginMethods = LoginMethods.getInstance();

    private RegistrationCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request){
        String page;
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
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
        for (byte newByte: byteData){
            sb.append(Integer.toString((newByte&0xff)+0x100,16).substring(1));
        }
        String passwordCipher = sb.toString();
        User userAfterCheck = loginMethods.checkLoginOrNewUser(login, passwordCipher);
        if (userAfterCheck!= null) {
            page = "registrationError.jsp";
        } else {
            User user = new User(isAdmin, login, passwordCipher,firstName, secondName, country,city,street, postIndex,phone);
            loginMethods.registration(user);
            request.setAttribute("user", user);
            page = "registrationOk.jsp";
        }
        return page;
    }
}
