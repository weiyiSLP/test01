package com.wei1.work.crm.settings.service;

import com.wei1.work.crm.exception.LoginException;
import com.wei1.work.crm.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
