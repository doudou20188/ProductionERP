package com.cskaoyan.domain.qualify.VO;

public class final_measuret_checkVO {
    private String fMeasureCheckId;

    private String orderId;

    private String checkItem;

    private String cdate;

    private String measureData;

    private String empId;

    private String result;

    private String note;

    String empName;

    public final_measuret_checkVO() {
    }

    public final_measuret_checkVO(String fMeasureCheckId, String orderId, String checkItem, String cdate, String measureData, String empId, String result, String note, String empName) {
        this.fMeasureCheckId = fMeasureCheckId;
        this.orderId = orderId;
        this.checkItem = checkItem;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empId = empId;
        this.result = result;
        this.note = note;
        this.empName = empName;
    }

    public String getfMeasureCheckId() {
        return fMeasureCheckId;
    }

    public void setfMeasureCheckId(String fMeasureCheckId) {
        this.fMeasureCheckId = fMeasureCheckId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getMeasureData() {
        return measureData;
    }

    public void setMeasureData(String measureData) {
        this.measureData = measureData;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
