package com.artem.filter;


import com.artem.session.SessionLocator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})

public class FilterController implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        session.setAttribute("messages", SessionLocator.addMessage(session));
        session.setMaxInactiveInterval(60 * 5);

        ClientType clientType = (ClientType) session.getAttribute("role");
        if (clientType == null) {
            clientType = ClientType.GUEST;
            session.setAttribute("role", clientType);
            String pageFoRole = "index.jsp";
            session.setAttribute("pageFoRole", pageFoRole);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/mainServlet");
            dispatcher.forward(req, resp);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
