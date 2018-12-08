package com.cskaoyan.domain.device;

public class Device {
    private String deviceId;

    private String deviceName;

    private String deviceTypeId;

    private String deviceStatusId;

    private String deviceStatus;

    private String devicePurchaseDate;

    private String devicePurchasePrice;

    private String deviceManufactureDate;

    private String deviceServiceLife;

    private String deviceKeeperId;

    private String note;

    private String deviceTypeName;
    private String deviceKeeper;

    @Override
    public String toString() {
        return "device{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceTypeId='" + deviceTypeId + '\'' +
                ", deviceStatusId='" + deviceStatusId + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", devicePurchaseDate='" + devicePurchaseDate + '\'' +
                ", devicePurchasePrice='" + devicePurchasePrice + '\'' +
                ", deviceManufactureDate='" + deviceManufactureDate + '\'' +
                ", deviceServiceLife='" + deviceServiceLife + '\'' +
                ", deviceKeeperId='" + deviceKeeperId + '\'' +
                ", note='" + note + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceKeeper='" + deviceKeeper + '\'' +
                '}';
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceStatusId() {
        return deviceStatusId;
    }

    public void setDeviceStatusId(String deviceStatusId) {
        this.deviceStatusId = deviceStatusId;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public void setDevicePurchaseDate(String devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public String getDevicePurchasePrice() {
        return devicePurchasePrice;
    }

    public void setDevicePurchasePrice(String devicePurchasePrice) {
        this.devicePurchasePrice = devicePurchasePrice;
    }

    public String getDeviceManufactureDate() {
        return deviceManufactureDate;
    }

    public void setDeviceManufactureDate(String deviceManufactureDate) {
        this.deviceManufactureDate = deviceManufactureDate;
    }

    public String getDeviceServiceLife() {
        return deviceServiceLife;
    }

    public void setDeviceServiceLife(String deviceServiceLife) {
        this.deviceServiceLife = deviceServiceLife;
    }

    public String getDeviceKeeperId() {
        return deviceKeeperId;
    }

    public void setDeviceKeeperId(String deviceKeeperId) {
        this.deviceKeeperId = deviceKeeperId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceKeeper() {
        return deviceKeeper;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper;
    }
}