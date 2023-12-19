package com.example.devicemanagement;

import java.util.Date;

public class Device {
    private String name;
    private String description;
    private String serialNumber;
    private Date purchaseDate;
    private int warranty;
    private String maintenanceStatus;
    private String locationOfDevice;
    private String operatingInstructions;
    private String contactPartner;
    private String picture;

    public void addDevice(String name, String description, String serialNumber, Date purchaseDate, int warranty, String maintenanceStatus, String locationOfDevice, String operatingInstructions, String contactPartner, String picture) {
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.warranty = warranty;
        this.maintenanceStatus = maintenanceStatus;
        this.locationOfDevice = locationOfDevice;
        this.operatingInstructions = operatingInstructions;
        this.contactPartner = contactPartner;
        this.picture = picture;
    }

    public void deleteDevice() {

    }
}
