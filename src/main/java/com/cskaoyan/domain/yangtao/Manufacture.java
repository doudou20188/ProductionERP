package com.cskaoyan.domain.yangtao;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Manufacture {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.manufacture_sn
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    private String manufactureSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.order_id
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.technology_id
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    private String technologyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.launch_quantity
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    private Integer launchQuantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.begin_date
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manufacture.end_date
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.manufacture_sn
     *
     * @return the value of manufacture.manufacture_sn
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public String getManufactureSn() {
        return manufactureSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.manufacture_sn
     *
     * @param manufactureSn the value for manufacture.manufacture_sn
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn == null ? null : manufactureSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.order_id
     *
     * @return the value of manufacture.order_id
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.order_id
     *
     * @param orderId the value for manufacture.order_id
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.technology_id
     *
     * @return the value of manufacture.technology_id
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public String getTechnologyId() {
        return technologyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.technology_id
     *
     * @param technologyId the value for manufacture.technology_id
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.launch_quantity
     *
     * @return the value of manufacture.launch_quantity
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public Integer getLaunchQuantity() {
        return launchQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.launch_quantity
     *
     * @param launchQuantity the value for manufacture.launch_quantity
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public void setLaunchQuantity(Integer launchQuantity) {
        this.launchQuantity = launchQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.begin_date
     *
     * @return the value of manufacture.begin_date
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.begin_date
     *
     * @param beginDate the value for manufacture.begin_date
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manufacture.end_date
     *
     * @return the value of manufacture.end_date
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manufacture.end_date
     *
     * @param endDate the value for manufacture.end_date
     *
     * @mbg.generated Fri Dec 07 22:28:08 CST 2018
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "manufactureSn='" + manufactureSn + '\'' +
                ", orderId='" + orderId + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", launchQuantity=" + launchQuantity +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}