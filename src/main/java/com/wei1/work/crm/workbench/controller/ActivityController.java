package com.wei1.work.crm.workbench.controller;

import com.wei1.work.crm.settings.domain.User;
import com.wei1.work.crm.settings.service.UserService;
import com.wei1.work.crm.settings.service.impl.UserServiceImp;
import com.wei1.work.crm.utils.PrintJson;
import com.wei1.work.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author WeiYi
 * @Date: Created in 21:47  2020/11/27
 */
public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if ("/workbench/activity/getUserList.do".equals(path)){
            getUserList(req,resp);
        }
    }
    private void getUserList(HttpServletRequest req,HttpServletResponse res){
        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImp());
        List<User> userList = userService.getUserList();
        PrintJson.printJsonObj(res,userList);
    }

}
