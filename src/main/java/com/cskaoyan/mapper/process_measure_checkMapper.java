package com.cskaoyan.mapper;

import com.cskaoyan.domain.process_measure_check;

public interface process_measure_checkMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(process_measure_check record);

    int insertSelective(process_measure_check record);

    process_measure_check selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(process_measure_check record);

    int updateByPrimaryKey(process_measure_check record);
}