package com.cskaoyan.service.impl.yangtao;

import com.cskaoyan.domain.yangtao.Corder;
import com.cskaoyan.mapper.yangtao.CorderMapper;
import com.cskaoyan.service.yangtao.CorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/7 0007
 */
@Service
public class CorderServiceImpl implements CorderService {
    @Autowired
    CorderMapper corderMapper;


    @Override
    public Corder findOrderById(String orderId) {
        Corder corder = corderMapper.selectByPrimaryKey(orderId);
        return corder;
    }

    @Override
    public List<Corder> findAllOrder() {
        List<Corder> corderList=corderMapper.findAllOrderFromDB();
        return corderList;
    }

    @Override
    public boolean addOrder(Corder corder) {
        boolean b=false;
        int i = corderMapper.insert(corder);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public boolean updateOrder(Corder corder) {
        boolean b =false;
        int i = corderMapper.updateByPrimaryKey(corder);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public boolean deleteOrders(String id) {
        boolean b =false;
        int i = corderMapper.deleteByPrimaryKey(id);
        if(i==1){
            b=true;
        }
        return b;
    }

    @Override
    public List<Corder> findOrdersByCustomId(String theCustomID) {
        List<Corder> corderList=corderMapper.findOrdersByCustomIdFromDB(theCustomID);
        return corderList;
    }

    @Override
    public List<Corder> findOrderByProductId(String theProductId) {
        List<Corder> corderList=corderMapper.findOrderByProductIdFromDB(theProductId);
        return corderList;
    }
}
