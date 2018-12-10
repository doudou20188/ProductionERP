package com.cskaoyan.service.yangtao;

import com.cskaoyan.domain.yangtao.Corder;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/7 0007
 */
public interface CorderService {
    Corder findOrderById(String orderId);

    List<Corder> findAllOrder();

    boolean addOrder(Corder corder);

    boolean updateOrder(Corder corder);

    boolean deleteOrders(String id);

    List<Corder> findOrdersByCustomId(String theCustomID);

    List<Corder> findOrderByProductId(String theProductId);
}
