package com.cj.javaweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJ
 * @date 2021/7/14 13:31
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 获取session中是否登陆的信息
        String isLogin = (String) request.getSession().getAttribute("isLogin");

        String servletPath = request.getServletPath();
        System.out.println("servletPath: " + servletPath);
        String contextPath = request.getContextPath();
        System.out.println("contextPath: " + contextPath);

        // 如果未登录，则转发到登陆页面
        boolean isAnonyPath = "/sys/login".equals(servletPath) ||
                "/sys/login.jsp".equals(servletPath) || "/sys/error.jsp".equals(servletPath);

        if (!"true".equals(isLogin)) {
            if (!isAnonyPath) {
                response.sendRedirect(request.getContextPath() + "/sys/login.jsp");
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
