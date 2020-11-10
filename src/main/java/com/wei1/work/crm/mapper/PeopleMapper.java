package com.wei1.work.crm.mapper;

import com.wei1.work.crm.domain.People;

public interface PeopleMapper {
    People selectById(String userId);
}
