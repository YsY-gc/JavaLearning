package com.ysy.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestdemo")
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        String queryString = req.getQueryString();
        System.out.println(queryString);
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        String protocol = req.getProtocol();
        System.out.println(protocol);
    }
}
