package com.example.devicemanagement;

import android.media.Image;

import java.util.Date;

public class Device {
    // Metadata:
    private int id;
    private String name;
    private String description;
    private String serialNumber;

    // Customer-dependent:
    private Date purchaseDate;
    private int warranty;
    private String locationOfDevice;
    private String contactPartner;

    // Current:
    private String maintenanceStatus;
    // private Date lastMaintenanceDate;

    // Big Data:
    // private String operatingInstructions;
    private Image image;


    public Device() {
        // Leerer Konstruktor wird von Firebase benötigt
    }

    public Device(int id, String name, String description, String serialNumber, Date purchaseDate, int warranty, String locationOfDevice, String contactPartner, String maintenanceStatus, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.warranty = warranty;
        this.locationOfDevice = locationOfDevice;
        this.contactPartner = contactPartner;
        this.maintenanceStatus = maintenanceStatus;
        // this.lastMaintenanceDate = lastMaintenanceDate;
        // this.operatingInstructions = operatingInstructions;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public int getWarranty() {
        return warranty;
    }

    public String getLocationOfDevice() {
        return locationOfDevice;
    }

    public String getContactPartner() {
        return contactPartner;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public Image getImage() {
        return image;
    }

    // TODO: Setter

    // TODO: new Device to database

}