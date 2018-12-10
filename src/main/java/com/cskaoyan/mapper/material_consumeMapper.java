package com.cskaoyan.mapper;

import com.cskaoyan.domain.material_consume;

public interface material_consumeMapper {
    int deleteByPrimaryKey(String consumeId);

    int insert(material_consume record);

    int insertSelective(material_consume record);

    material_consume selectByPrimaryKey(String consumeId);

    int updateByPrimaryKeySelective(material_consume record);

    int updateByPrimaryKey(material_consume record);
}