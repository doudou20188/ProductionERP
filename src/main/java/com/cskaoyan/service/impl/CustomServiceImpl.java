package com.cskaoyan.service.impl;

import com.cskaoyan.domain.Custom;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/8 0008
 */
@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> findAllCustom() {
        List<Custom> customList=customMapper.findAllCustomFromDB();
        return customList;
    }

    @Override
    public Custom findCustomById(String customId) {
        Custom custom = customMapper.selectByPrimaryKey(customId);
        return custom;
    }

    @Override
    public boolean addCustom(Custom custom) {
        boolean b = false;
        int i = customMapper.insertSelective(custom);
        if (i==1){
            b = true;
        }
        return b;
    }

    @Override
    public boolean updateCustom(Custom custom) {
        boolean b =false;
        int i = customMapper.updateByPrimaryKeySelective(custom);
        if (i==1){
            b= true;
        }
        return b;
    }

    @Override
    public boolean deleteById(String id) {
        boolean b =false;
        int i = customMapper.deleteByPrimaryKey(id);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public Custom findCustomByName(String searchValue) {
        Custom custom=customMapper.findCustomByNameFromDB(searchValue);
        return custom;
    }
}
