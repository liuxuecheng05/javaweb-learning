package com.example.class01servle;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
@WebServlet(value = "/demo3",name = "/demo3")
public class ServletDemo3 implements Servlet {
    /**
     * Servlet 初始化
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servelt 初始化");
    }

    /**
     *获取 Servlet配置
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 执行service方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("Servletdemo3 执行");
        System.out.println("service 执行");
    }

    /**
     * 获取servlet信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 执行销毁方法
     */
    @Override
    public void destroy() {

    }
}
