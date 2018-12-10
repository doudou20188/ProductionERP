package com.cskaoyan.service.yangtao;

import com.cskaoyan.domain.yangtao.Custom;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/8 0008
 */
public interface CustomService {
    List<Custom> findAllCustom();

    Custom findCustomById(String customId);

    boolean addCustom(Custom custom);

    boolean updateCustom(Custom custom);

    boolean deleteById(String id);

    Custom findCustomByName(String searchValue);
}
