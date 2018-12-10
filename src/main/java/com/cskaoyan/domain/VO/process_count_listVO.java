package com.cskaoyan.domain.VO;

import java.util.Arrays;

public class process_count_listVO {
    String total;
    process_count_checkVO[]   rows;

    public process_count_listVO() {
    }

    public process_count_listVO(String total, process_count_checkVO[] rows) {
        this.total = total;
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public process_count_checkVO[] getRows() {
        return rows;
    }

    public void setRows(process_count_checkVO[] rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "process_count_listVO{" +
                "total='" + total + '\'' +
                ", rows=" + Arrays.toString(rows) +
                '}';
    }
}
