package com.cskaoyan.domain.VO;
import com.cskaoyan.domain.VO.final_measuret_checkVO;

import java.util.Arrays;

public class final_measuret_listVO {
    String total;
    final_measuret_checkVO[]   rows;

    public final_measuret_listVO() {
    }

    public final_measuret_listVO(String total, final_measuret_checkVO[] rows) {
        this.total = total;
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public final_measuret_checkVO[] getRows() {
        return rows;
    }

    public void setRows(final_measuret_checkVO[] rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "final_measuret_listVO{" +
                "total='" + total + '\'' +
                ", rows=" + Arrays.toString(rows) +
                '}';
    }
}
