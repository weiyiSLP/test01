package com.wei1.work.crm.web.filter;

import com.wei1.work.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if ("/login.jsp".equals(httpServletRequest.getServletPath())||"/settings/user/login.do".equals(httpServletRequest.getServletPath())||"/index.jsp".equals(httpServletRequest.getServletPath())){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            if (user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                //重定向
                //路径写法：在实际项目开发中，实用都是绝对路径
                //转发和重定向路径的写法
                //转发：这种不加/项目名，是一种内部路径
                //重定向：使用/crm/login.jsp这种绝对路径
                //getContextPath（）拿项目名/crm
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.jsp");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
