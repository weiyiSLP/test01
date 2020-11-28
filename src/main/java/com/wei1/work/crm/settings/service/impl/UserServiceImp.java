package com.wei1.work.crm.settings.service.impl;

import com.wei1.work.crm.exception.LoginException;
import com.wei1.work.crm.settings.domain.User;
import com.wei1.work.crm.settings.mapper.UserMapper;
import com.wei1.work.crm.settings.service.UserService;
import com.wei1.work.crm.utils.DateTimeUtil;
import com.wei1.work.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImp implements UserService {
private UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        Map<String,Object> map = new HashMap();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);

        User user = userMapper.login(map);
        if (user ==null){
            throw new LoginException("账号或密码错误");
        }
        //判断失效时间
        String expireTime = user.getExpireTime();
        String time = DateTimeUtil.getSysTime();
        if (expireTime.compareTo(time)<0){
            throw new LoginException("账号过期");
        }
        //判断锁定状态
        String lockState =user.getLockState();
        if ("0".equals(lockState)){
            throw new LoginException("账号被锁定，请联系管理员进行解封");
        }
        String allowIp = user.getAllowIps();
        if (!allowIp.contains(ip)){
            throw new LoginException("您的Ip不在本公司范围内");
        }
        return user;
    }

    @Override
    public List<User> getUserList() {
      List<User> userList =  userMapper.getUserList();
      return userList;
    }

}
