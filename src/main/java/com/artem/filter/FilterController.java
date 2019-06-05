package com.artem.filter;

import com.artem.command.RegistrationCommand;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter (urlPatterns = {"/*"})

public class FilterController implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        ClientType clientType = (ClientType)session.getAttribute("role");
        if (clientType==null){
            clientType = ClientType.GUEST;
            session.setAttribute("role", clientType);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/mainServlet");
            dispatcher.forward(req,resp);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);


    }

    @Override
    public void destroy() {

    }
}
