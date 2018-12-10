package com.cskaoyan.mapper;

import com.cskaoyan.domain.final_count_check;

public interface final_count_checkMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(final_count_check record);

    int insertSelective(final_count_check record);

    final_count_check selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(final_count_check record);

    int updateByPrimaryKey(final_count_check record);
}