package com.cskaoyan.service.impl;

import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: YangTao
 * @Date: 2018/12/7 0007
 */
@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;



}
