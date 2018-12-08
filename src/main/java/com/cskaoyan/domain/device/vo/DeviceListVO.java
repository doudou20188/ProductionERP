package com.cskaoyan.domain.device.vo;

import com.cskaoyan.domain.device.Device;

import java.util.Arrays;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/6 21:31
 * 将bean转换为Json的bean
 **/
public class DeviceListVO {
    int total;
    Device[] rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Device[] getRows() {
        return rows;
    }

    public void setRows(Device[] rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DeviceListVO{" +
                "total=" + total +
                ", rows=" + Arrays.toString(rows) +
                '}';
    }
}
