package com.cskaoyan.mapper;

import com.cskaoyan.domain.material;

public interface materialMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(material record);

    int insertSelective(material record);

    material selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(material record);

    int updateByPrimaryKey(material record);
}