package com.wei1.work.crm.settings.controller;

import com.wei1.work.crm.settings.domain.User;
import com.wei1.work.crm.settings.service.UserService;
import com.wei1.work.crm.settings.service.impl.UserServiceImp;
import com.wei1.work.crm.utils.MD5Util;
import com.wei1.work.crm.utils.PrintJson;
import com.wei1.work.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    //采用分模块进行编写以便简化servlet的数量
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.contains("/settings/user/login.do")) {
            login(request, response);
        }
    }
    private void login(HttpServletRequest request, HttpServletResponse response) {
        //从请求中获取相关登录信息
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        loginPwd = MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();
        //通过Service对象操作Dao层进行验证数据的正确性
        //使用代理获取事物的管理，代理类中有事物的定义
        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImp());
        try{
            //提交给dao层
            User user = userService.login(loginAct,loginPwd,ip);
            //将user放到session中进行保存
            request.getSession().setAttribute("user",user);
            PrintJson.printJsonFlag(response,true);
        }catch (Exception e){
            String msg = e.getMessage();
            Map<String,Object> map = new HashMap<>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);
        }

    }


}
