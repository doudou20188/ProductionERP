package com.cskaoyan.mapper;

import com.cskaoyan.domain.process_count_check;

public interface process_count_checkMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(process_count_check record);

    int insertSelective(process_count_check record);

    process_count_check selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(process_count_check record);

    int updateByPrimaryKey(process_count_check record);
}