package com.cskaoyan.domain.yangtao;

public class Work {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work.work_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    private String workId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work.process_number
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    private String processNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work.product_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    private String productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work.process_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    private String processId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work.device_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    private String deviceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work.rating
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    private Integer rating;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work.work_id
     *
     * @return the value of work.work_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work.work_id
     *
     * @param workId the value for work.work_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work.process_number
     *
     * @return the value of work.process_number
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public String getProcessNumber() {
        return processNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work.process_number
     *
     * @param processNumber the value for work.process_number
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber == null ? null : processNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work.product_id
     *
     * @return the value of work.product_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public String getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work.product_id
     *
     * @param productId the value for work.product_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work.process_id
     *
     * @return the value of work.process_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work.process_id
     *
     * @param processId the value for work.process_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work.device_id
     *
     * @return the value of work.device_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work.device_id
     *
     * @param deviceId the value for work.device_id
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work.rating
     *
     * @return the value of work.rating
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work.rating
     *
     * @param rating the value for work.rating
     *
     * @mbg.generated Sun Dec 09 16:54:23 CST 2018
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workId='" + workId + '\'' +
                ", processNumber='" + processNumber + '\'' +
                ", productId='" + productId + '\'' +
                ", processId='" + processId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", rating=" + rating +
                '}';
    }
}