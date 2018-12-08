package com.cskaoyan.domain.device.vo;

import com.cskaoyan.domain.device.DeviceCheck;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/8 17:17
 **/
public class DeviceCheckVO {
    int total;
    DeviceCheck[] rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public DeviceCheck[] getRows() {
        return rows;
    }

    public void setRows(DeviceCheck[] rows) {
        this.rows = rows;
    }
}
