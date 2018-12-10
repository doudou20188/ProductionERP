package com.cskaoyan.domain.device.vo;

import com.cskaoyan.domain.device.DeviceMaintain;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/9 13:30
 **/
public class DeviceMaintainListVO {
    int total;
    DeviceMaintain[] rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public DeviceMaintain[] getRows() {
        return rows;
    }

    public void setRows(DeviceMaintain[] rows) {
        this.rows = rows;
    }
}
