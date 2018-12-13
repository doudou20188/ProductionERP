package com.cskaoyan.service.material.Impl;

import com.cskaoyan.controller.customize.CustomResult;

import com.cskaoyan.domain.Material.Material;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;
    @Override
    public List<Material> getdata() {

        return materialMapper.selectByPage();
       // return materialMapper.getdata();
    }


    //分页查询未完成
    @Override
    public Map findmaterial(Integer page, Integer rows) {
        //public PageInfo<Material> findmaterial(Integer page, Integer rows) {
        Map hashMap = new HashMap();
        //PageHelper.startPage(page, rows);
        List<Material> materials = materialMapper.selectByPage();

        // PageInfo<Material> pageInfo = new PageInfo<>(Materials);
        //System.out.println(pageInfo);
        hashMap.put("rows", materials);
        hashMap.put("total", materials.size());
        //return pageInfo;
        return hashMap;
    }

        @Override
    public CustomResult insertMaterial(Material material) {
        int insert = materialMapper.insert(material);
        if (insert == 1) {
            return CustomResult.ok();
        } else {
            return CustomResult.build(101, "添加数据失败");
        }

    }

    @Override
    public CustomResult delete_batch(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            int insert = materialMapper.deleteByPrimaryKey(ids[i]);
            if (insert != 1) {
                return CustomResult.build(101, "删除错误");
            }
          }
        return CustomResult.ok();
    }

    @Override
    public CustomResult update_all(Material material) {
        int update = materialMapper.updateByPrimaryKey(material);
        if (update==1){
            return CustomResult.ok();
        }
        return CustomResult.build(101,"操错错误");
    }

    @Override
    public Map SearchMaterialByMaterialId(Integer page, Integer rows, String searchValue) {
        List<Material> materials = materialMapper.selectMaterialByID(searchValue);
        Map hashmap=new HashMap();
        hashmap.put("total",materials.size());
        hashmap.put("rows",materials);
        return hashmap;
    }

    @Override
    public Map SearchMaterialByMaterialType(Integer page, Integer rows, String searchValue) {
        List<Material> materials = materialMapper.SearchMaterialByMaterialType(searchValue);
        Map hashmap=new HashMap();
        hashmap.put("total",materials.size());
        hashmap.put("rows",materials);
        return hashmap;
    }
}

