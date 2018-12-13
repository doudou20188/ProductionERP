package com.cskaoyan.domain.qualify.VO;

public class final_count_listVO {
    String total;
    final_count_checkVO[]   rows;

    public final_count_listVO() {
    }

    public final_count_listVO(String total, final_count_checkVO[] rows) {
        this.total = total;
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public final_count_checkVO[] getRows() {
        return rows;
    }

    public void setRows(final_count_checkVO[] rows) {
        this.rows = rows;
    }
}
