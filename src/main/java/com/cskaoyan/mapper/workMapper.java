package com.cskaoyan.mapper;

import com.cskaoyan.domain.work;

public interface workMapper {
    int deleteByPrimaryKey(String workId);

    int insert(work record);

    int insertSelective(work record);

    work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(work record);

    int updateByPrimaryKey(work record);
}