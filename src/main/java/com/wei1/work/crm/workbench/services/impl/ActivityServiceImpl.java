package com.wei1.work.crm.workbench.services.impl;

import com.wei1.work.crm.utils.SqlSessionUtil;
import com.wei1.work.crm.workbench.mapper.ActivityMapper;
import com.wei1.work.crm.workbench.services.ActivityService;

/**
 * @Author WeiYi
 * @Date: Created in 15:54  2020/11/27
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityMapper mapper = SqlSessionUtil.getSqlSession().getMapper(ActivityMapper.class);
}
