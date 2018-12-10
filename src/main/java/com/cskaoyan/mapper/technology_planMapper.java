package com.cskaoyan.mapper;

import com.cskaoyan.domain.technology_plan;

public interface technology_planMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(technology_plan record);

    int insertSelective(technology_plan record);

    technology_plan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(technology_plan record);

    int updateByPrimaryKey(technology_plan record);
}