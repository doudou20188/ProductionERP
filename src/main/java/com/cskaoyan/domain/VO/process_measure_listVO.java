package com.cskaoyan.domain.VO;

import java.util.Arrays;

public class process_measure_listVO {
    String total;
    process_measure_checkVO[]   rows;

    public process_measure_listVO() {
    }

    public process_measure_listVO(String total, process_measure_checkVO[] rows) {
        this.total = total;
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public process_measure_checkVO[] getRows() {
        return rows;
    }

    public void setRows(process_measure_checkVO[] rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "process_measure_listVO{" +
                "total='" + total + '\'' +
                ", rows=" + Arrays.toString(rows) +
                '}';
    }
}
