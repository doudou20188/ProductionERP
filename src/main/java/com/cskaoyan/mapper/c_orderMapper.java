package com.cskaoyan.mapper;

import com.cskaoyan.domain.c_order;

public interface c_orderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(c_order record);

    int insertSelective(c_order record);

    c_order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(c_order record);

    int updateByPrimaryKey(c_order record);
}