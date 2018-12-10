package com.cskaoyan.mapper;

import com.cskaoyan.domain.custom;

public interface customMapper {
    int deleteByPrimaryKey(String customId);

    int insert(custom record);

    int insertSelective(custom record);

    custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(custom record);

    int updateByPrimaryKey(custom record);
}