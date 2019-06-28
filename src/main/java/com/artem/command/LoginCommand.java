package com.artem.command;

import com.artem.filter.ClientType;
import com.artem.methods.LoginMethods;
import com.artem.session.SessionLocator;
import com.artem.users.User;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginCommand implements Command {
    private static final Command INSTANCE = new LoginCommand();
    private final LoginMethods loginMethods = LoginMethods.getInstance();

    private LoginCommand() {
    }

    public static Command getInstance() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request)  {
        String page;
        HttpSession session=request.getSession(true);
        ClientType clientType;
        String login= request.getParameter("login");
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
        for (byte newByte: byteData){
            sb.append(Integer.toString((newByte&0xff)+0x100,16).substring(1));
        }
        String passwordCipher = sb.toString();
        User user = loginMethods.checkLoginOrNewUser(login, passwordCipher);

        if (user != null) {
            session.setAttribute("loginForOrder",login);
            session.setAttribute("passwordForOrder",passwordCipher);
            if (user.isAdmin()) {
                clientType = ClientType.ADMIN;
                session.setAttribute("role", clientType);
            } else {
                clientType = ClientType.USER;
                session.setAttribute("role", clientType);
            }
            request.setAttribute("user", user);
            page = "checkLoginOk.jsp";
        } else {
            page = "checkLoginError.jsp";
        }
        return page;
    }
}
