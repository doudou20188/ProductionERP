package com.cskaoyan;

import com.cskaoyan.dao.Device;
import com.cskaoyan.mapper.DeviceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/6 17:01
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class MyTest {
    @Autowired
    DeviceMapper deviceMapper;
    @Test
    public void Test1(){
        Device device = deviceMapper.selectByPrimaryKey("001");
        System.out.println(device);
    }
}
