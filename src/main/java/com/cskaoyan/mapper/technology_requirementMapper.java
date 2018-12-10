package com.cskaoyan.mapper;

import com.cskaoyan.domain.technology_requirement;

public interface technology_requirementMapper {
    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(technology_requirement record);

    int insertSelective(technology_requirement record);

    technology_requirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(technology_requirement record);

    int updateByPrimaryKey(technology_requirement record);
}