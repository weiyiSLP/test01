package com.wei1.work.crm.settings.mapper;

import com.wei1.work.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User login(Map<String, Object> map);

    List<User> getUserList();
}
