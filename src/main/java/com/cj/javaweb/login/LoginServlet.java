package com.cj.javaweb.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJ
 * @date 2021/7/14 13:32
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "abc123".equals(password)) {
            // 通过验证，在session中放上已登陆标记，并转发到主页上
            req.getSession().setAttribute("isLogin","true");
            resp.sendRedirect(req.getContextPath() + "/sys/success.jsp");
        } else {
            // 用户名密码错误，转发到错误页面
            resp.sendRedirect(req.getContextPath() + "/sys/error.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
