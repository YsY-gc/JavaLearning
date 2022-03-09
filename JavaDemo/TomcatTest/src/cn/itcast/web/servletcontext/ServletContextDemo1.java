package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();


        //ServletContext 作用1：获取文件mime类型
        String fileName = "a.jpg";
        String mimeType = servletContext.getMimeType(fileName);
        System.out.println(mimeType);

        //ServletContext 作用2：域共享
        servletContext.setAttribute("msg", "Hello!");

        //ServletContext 作用3：获取文件真实路径
        String aPath = servletContext.getRealPath("/WEB-INF/classes/a.txt"); //WEB-INF 目录下
        System.out.println(aPath);

        String bPath = servletContext.getRealPath("/b.txt"); // web目录下
        System.out.println(bPath);

        String cPath = servletContext.getRealPath("/WEB-INF/a.txt"); //src目录下
        System.out.println(cPath);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
