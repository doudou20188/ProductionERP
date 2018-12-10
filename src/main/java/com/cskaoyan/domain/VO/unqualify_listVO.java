package com.cskaoyan.domain.VO;


import java.util.Arrays;

public class unqualify_listVO {
    String total;
    unqualify_applyVO[]   rows;

    public unqualify_listVO() {
    }

    public unqualify_listVO(String total, unqualify_applyVO[] rows) {
        this.total = total;
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public unqualify_applyVO[] getRows() {
        return rows;
    }

    public void setRows(unqualify_applyVO[] rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "unqualify_listVO{" +
                "total='" + total + '\'' +
                ", rows=" + Arrays.toString(rows) +
                '}';
    }
}
