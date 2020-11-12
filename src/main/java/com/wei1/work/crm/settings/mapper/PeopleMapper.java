package com.wei1.work.crm.settings.mapper;

import com.wei1.work.crm.settings.domain.People;

public interface PeopleMapper {
    People selectById(String userId);
}
