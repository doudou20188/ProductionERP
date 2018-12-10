package com.cskaoyan.domain.device.vo;

import com.cskaoyan.domain.device.DeviceFault;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/9 12:29
 **/
public class DeviceFaultListVO {
    int total;
    DeviceFault[] rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public DeviceFault[] getRows() {
        return rows;
    }

    public void setRows(DeviceFault[] rows) {
        this.rows = rows;
    }
}
