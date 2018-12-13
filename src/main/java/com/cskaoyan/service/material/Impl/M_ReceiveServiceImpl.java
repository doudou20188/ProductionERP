package com.cskaoyan.service.material.Impl;

import com.cskaoyan.controller.customize.CustomResult;
import com.cskaoyan.domain.Material.M_Receive;
import com.cskaoyan.mapper.material.M_ReceiveMapper;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.service.material.M_ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class M_ReceiveServiceImpl implements M_ReceiveService {
    @Autowired
    M_ReceiveMapper m_receiveMapper;
    @Autowired
    MaterialMapper materialMapper;
    @Override
    public Map findm_receiveService(Integer page, Integer rows) {
        //public PageInfo<Material> findmaterial(Integer page, Integer rows) {
        Map hashMap = new HashMap();
        //PageHelper.startPage(page, rows);
        List<M_Receive> m_receives = m_receiveMapper.find();

        // PageInfo<Material> pageInfo = new PageInfo<>(materials);
        //System.out.println(pageInfo);
        hashMap.put("rows", m_receives);
        hashMap.put("total", m_receives.size());
        //return pageInfo;
        return hashMap;
    }

    @Override
    public List<M_Receive> getData() {
        List<M_Receive> m_receives = m_receiveMapper.find();
        return m_receives;
    }
    @Override
    public CustomResult insert(M_Receive m_receive) {
        //添加ID重复。，报错
        try {
            int insert = m_receiveMapper.insert(m_receive);

            if (insert==1){
                System.out.println(insert);
                return CustomResult.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return   CustomResult.build(101,"ID重复，请重新输入");
        }

        return   CustomResult.build(101,"添加失败，请重试");



    }

    @Override
    public CustomResult update_all(M_Receive m_receive) {
        int update = m_receiveMapper.updateByPrimaryKeySelective(m_receive);
        if (update==1){
            return CustomResult.ok();
        }
        return CustomResult.build(101,"操作错误");
    }

    @Override
    public CustomResult delete_batch(String[] ids) {
        for(int i=0;i<ids.length;i++) {
            int i1 = m_receiveMapper.deleteByPrimaryKey(ids[i]);
            if (i1!=1){
                return CustomResult.build(101,"删除错误");
            }
        }
        return CustomResult.ok();
    }

    @Override
    public Map SearchMaterialReceiveByMaterialId(Integer page, Integer rows, String searchValue) {
        List materialReceiveList = m_receiveMapper.SearchMaterialReceiveByMaterialId(searchValue);
        Map hashmap=new HashMap();
        hashmap.put("total",materialReceiveList.size());
        hashmap.put("rows",materialReceiveList);
        return hashmap;
    }
    @Override
    public Map SearchMaterialReceiveByReceiveId(Integer page, Integer rows, String searchValue){
        List list = m_receiveMapper.searchMaterialReceiveByReceiveId(searchValue);
        Map hashmap=new HashMap();
        hashmap.put("total",list.size());
        hashmap.put("rows",list);
        return hashmap;

    }


}
