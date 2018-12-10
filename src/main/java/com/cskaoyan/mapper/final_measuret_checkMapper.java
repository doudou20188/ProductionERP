package com.cskaoyan.mapper;

import com.cskaoyan.domain.final_measuret_check;

public interface final_measuret_checkMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(final_measuret_check record);

    int insertSelective(final_measuret_check record);

    final_measuret_check selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(final_measuret_check record);

    int updateByPrimaryKey(final_measuret_check record);
}