package com.artem.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class Cookies {

    public static void setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("site", "HEADPHONES_SHOP_BY");
        String value = response.getLocale().toString();
        Cookie loc = new Cookie("locale", value);
        response.addCookie(cookie);
        response.addCookie(loc);

    }

    public static List<String> addToRequest(HttpServletRequest request) {
        List<String> messagesCookie = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            messagesCookie.add("Number cookies: " + cookies.length);
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                messagesCookie.add(c.getName() + " = " + c.getValue());
            }
        }
        return messagesCookie;
    }
}
