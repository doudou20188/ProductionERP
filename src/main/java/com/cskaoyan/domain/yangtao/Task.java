package com.cskaoyan.domain.yangtao;

public class Task {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_id
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.manufacture_sn
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    private String manufactureSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.work_id
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    private String workId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_quantity
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    private Integer taskQuantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.working_hours
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    private Long workingHours;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_id
     *
     * @return the value of task.task_id
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.task_id
     *
     * @param taskId the value for task.task_id
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.manufacture_sn
     *
     * @return the value of task.manufacture_sn
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public String getManufactureSn() {
        return manufactureSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.manufacture_sn
     *
     * @param manufactureSn the value for task.manufacture_sn
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn == null ? null : manufactureSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.work_id
     *
     * @return the value of task.work_id
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.work_id
     *
     * @param workId the value for task.work_id
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_quantity
     *
     * @return the value of task.task_quantity
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public Integer getTaskQuantity() {
        return taskQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.task_quantity
     *
     * @param taskQuantity the value for task.task_quantity
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public void setTaskQuantity(Integer taskQuantity) {
        this.taskQuantity = taskQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.working_hours
     *
     * @return the value of task.working_hours
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public Long getWorkingHours() {
        return workingHours;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.working_hours
     *
     * @param workingHours the value for task.working_hours
     *
     * @mbg.generated Thu Dec 06 22:28:46 CST 2018
     */
    public void setWorkingHours(Long workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", manufactureSn='" + manufactureSn + '\'' +
                ", workId='" + workId + '\'' +
                ", taskQuantity=" + taskQuantity +
                ", workingHours=" + workingHours +
                '}';
    }
}