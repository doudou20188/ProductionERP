package com.cskaoyan.service.material.Impl;

import com.cskaoyan.controller.customize.CustomResult;
import com.cskaoyan.domain.Material.M_Consume;
import com.cskaoyan.domain.Material.Vo.MaterialConsumeVO;
import com.cskaoyan.mapper.material.M_ConsumeMapper;
import com.cskaoyan.service.material.M_ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class M_ConsumeServiceImpl implements M_ConsumeService {

    @Autowired
    M_ConsumeMapper m_consumeMapper;
    @Override
    public Map findlist(Integer page, Integer rows, MaterialConsumeVO materialConsume) {
        Map hashMap=new HashMap();
        List<MaterialConsumeVO> list = m_consumeMapper.find(materialConsume);

        System.out.println(list);
        hashMap.put("total",list.size());
        hashMap.put("rows",list);

        return hashMap;


    }

    @Override
    //public CustomResult insertMc(MaterialConsumeVO materialConsumeVO) {
    public CustomResult insert(M_Consume m_consume) {

        int insert = m_consumeMapper.insert(m_consume);
        if (insert==1){
            return  CustomResult.ok();
        }
        return CustomResult.build(101,"添加失败");
    }

    @Override
    public CustomResult delete_batch(String[] ids) {
        for (int i=0;i<ids.length;i++) {
            int i1 = m_consumeMapper.deleteByPrimaryKey(ids[i]);

            if (i1!=1){
                return CustomResult.build(101,"删除错误");
            }
        }
        return CustomResult.ok();
    }

    @Override
    public CustomResult update(M_Consume m_consume) {
        int update = m_consumeMapper.updateByPrimaryKey(m_consume);
        if (update==1){
            return CustomResult.ok();
        }
        return CustomResult.build(101,"修改失败");
    }

    @Override
    public Map searchMaterialConsumeByConsumeId(Integer page, Integer rows, String searchValue) {
        List<MaterialConsumeVO> materialConsumeVOS = m_consumeMapper.searchMaterialConsumeByConsumeId(searchValue);
        Map hash=new HashMap();
        hash.put("total",materialConsumeVOS.size());
        hash.put("rows",materialConsumeVOS);
        return hash;
    }

    @Override
    public Map searchMaterialConsumeByMaterialId(Integer page, Integer rows, String searchValue) {
        List<MaterialConsumeVO> materialConsumeList = m_consumeMapper.searchMaterialConsumeByMaterialId(searchValue);
        Map hash=new HashMap();
        hash.put("total",materialConsumeList.size());
        hash.put("rows",materialConsumeList);
        return hash;
    }

    @Override
    public Map searchMaterialConsumeByWorkId(Integer page, Integer rows, String searchValue) {
        List<MaterialConsumeVO> materialConsumeVOS = m_consumeMapper.searchMaterialConsumeByWorkId(searchValue);
        Map hash=new HashMap();
        hash.put("total",materialConsumeVOS.size());
        hash.put("rows",materialConsumeVOS);
        return hash;
    }
}
