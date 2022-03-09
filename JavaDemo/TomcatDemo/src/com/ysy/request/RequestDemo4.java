package com.ysy.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestdemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4...");

        //服务器内部资源跳转
        req.setAttribute("msg", "hello");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestdemo5");
        requestDispatcher.forward(req, resp);
    }
}
