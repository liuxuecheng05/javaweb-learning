package com.example.class01servle;

import jakarta.servlet.*;

import java.io.IOException;

public class ServletDemo1 implements Servlet {
    /**
     * Servlet 初始化
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet 初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 执行 Service 方法
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("servletDemo1");
        System.out.println("service 执行");
    }


    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
