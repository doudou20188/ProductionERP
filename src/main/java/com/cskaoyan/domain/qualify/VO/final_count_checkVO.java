package com.cskaoyan.domain.qualify.VO;

import java.math.BigDecimal;

public class final_count_checkVO {
    private String fCountCheckId;

    private String orderId;

    private String checkItem;

    private Integer sample;

    private Integer checkNumber;

    private Integer unqualify;

    private BigDecimal qualify;

    private String cdate;

    private String measureData;

    private String empId;

    private String result;

    private String note;
    String empName;

    public final_count_checkVO() {
    }

    public final_count_checkVO(String fCountCheckId, String orderId, String checkItem, Integer sample, Integer checkNumber, Integer unqualify, BigDecimal qualify, String cdate, String measureData, String empId, String result, String note, String empName) {
        this.fCountCheckId = fCountCheckId;
        this.orderId = orderId;
        this.checkItem = checkItem;
        this.sample = sample;
        this.checkNumber = checkNumber;
        this.unqualify = unqualify;
        this.qualify = qualify;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empId = empId;
        this.result = result;
        this.note = note;
        this.empName = empName;
    }

    public String getfCountCheckId() {
        return fCountCheckId;
    }

    public void setfCountCheckId(String fCountCheckId) {
        this.fCountCheckId = fCountCheckId;
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

    public Integer getSample() {
        return sample;
    }

    public void setSample(Integer sample) {
        this.sample = sample;
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Integer getUnqualify() {
        return unqualify;
    }

    public void setUnqualify(Integer unqualify) {
        this.unqualify = unqualify;
    }

    public BigDecimal getQualify() {
        return qualify;
    }

    public void setQualify(BigDecimal qualify) {
        this.qualify = qualify;
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

    @Override
    public String toString() {
        return "final_count_checkVO{" +
                "fCountCheckId='" + fCountCheckId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", checkItem='" + checkItem + '\'' +
                ", sample=" + sample +
                ", checkNumber=" + checkNumber +
                ", unqualify=" + unqualify +
                ", qualify=" + qualify +
                ", cdate='" + cdate + '\'' +
                ", measureData='" + measureData + '\'' +
                ", empId='" + empId + '\'' +
                ", result='" + result + '\'' +
                ", note='" + note + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
