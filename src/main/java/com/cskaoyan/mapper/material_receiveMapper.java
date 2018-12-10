package com.cskaoyan.mapper;

import com.cskaoyan.domain.material_receive;

public interface material_receiveMapper {
    int deleteByPrimaryKey(String receiveId);

    int insert(material_receive record);

    int insertSelective(material_receive record);

    material_receive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(material_receive record);

    int updateByPrimaryKey(material_receive record);
}