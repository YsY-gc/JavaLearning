package com.ysy.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysy.domain.Province;
import com.ysy.service.ProvinceService;
import com.ysy.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用service查询
        ProvinceService provinceService = new ProvinceServiceImpl();
//        List<Province> list = provinceService.findAll();
//
//        //2.将查询结果序列化为Json
//        ObjectMapper mapper = new ObjectMapper();
        String json = provinceService.findAllJson();

        System.out.println(json);

        //3.设置响应
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
