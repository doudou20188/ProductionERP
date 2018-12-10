package com.cskaoyan.service.impl.yangtao;

import com.cskaoyan.domain.yangtao.Manufacture;
import com.cskaoyan.mapper.yangtao.ManufactureMapper;
import com.cskaoyan.service.yangtao.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/7 0007
 */
@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;


    @Override
    public List<Manufacture> findAllManufacture() {
        List<Manufacture> manufactureList=manufactureMapper.findAllManufactureFromDB();
        return manufactureList;
    }

    @Override
    public boolean addManfacture(Manufacture manufacture) {
        boolean b =false;
        int i = manufactureMapper.insert(manufacture);
        if (i==1){
            b=true;
        }
        return b;
    }


    @Override
    public boolean deleteManufactureById(String ids) {
        boolean b =false;
        int i = manufactureMapper.deleteByPrimaryKey(ids);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public boolean updateManufacture(Manufacture manufacture) {
        boolean b =false;
        int i = manufactureMapper.updateByPrimaryKeySelective(manufacture);
        if (i==1){
            b =true;
        }
        return b;
    }

    @Override
    public Manufacture findManufactureById(String searchValue) {
        Manufacture manufacture = manufactureMapper.selectByPrimaryKey(searchValue);
        return manufacture;
    }

    @Override
    public List<Manufacture> findManufactureByOrderId(String searchValue) {
        List<Manufacture> manufactureList=manufactureMapper.findManufactureByOrderIdFromDB(searchValue);

        return manufactureList;
    }

    @Override
    public List<Manufacture> findManufactureByTeachnologyId(String technologyId) {
        List<Manufacture> manufactureList=manufactureMapper.findManufactureByTeachnologyIdFromDB(technologyId);
        return manufactureList;
    }

    @Override
    public Manufacture findManutureByTechID(String technologyId) {
        Manufacture manufacture=manufactureMapper.findManutureByTechIDFromDB(technologyId);
        return manufacture;
    }

}
