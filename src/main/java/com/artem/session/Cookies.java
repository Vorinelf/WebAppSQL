package com.artem.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class Cookies {
    private static int number = 1;


    public static void setCookie (HttpServletResponse response) {
        String name = "cookie";
        String cook = "Cookies is OK";
        Cookie cookie = new Cookie(name,cook);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        String value = response.getLocale().toString();
        Cookie loc = new Cookie("locale",value);
        response.addCookie(loc);
    }

    public static List<String> addToRequest (HttpServletRequest request) {
        List<String> messagesCookie = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            messagesCookie.add("Number cookies: " + cookies.length);
            for (int i=0; i<cookies.length;i++) {
                Cookie c = cookies[i];
                messagesCookie.add(c.getName() + " = " + c.getValue());
            }
        }return messagesCookie;
    }
}
