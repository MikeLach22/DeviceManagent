package com.example.devicemanagement;

public class Device {

    private int id;
    private String name;
    private String description;

    public Device() {
        // Leerer Konstruktor wird von Firebase benötigt
    }

    public Device(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
}

/* public class Device {
    private String name;
    private String description;
    private String serialNumber;
    private Date purchaseDate;
    private int warranty;
    private String maintenanceStatus;
    private String locationOfDevice;
    private String operatingInstructions;
    private String contactPartner;
    private Image image;

    public Device(String name, String description, String serialNumber, Date purchaseDate, int warranty, String maintenanceStatus, String locationOfDevice, String operatingInstructions, String contactPartner, Image image) {
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.warranty = warranty;
        this.maintenanceStatus = maintenanceStatus;
        this.locationOfDevice = locationOfDevice;
        this.operatingInstructions = operatingInstructions;
        this.contactPartner = contactPartner;
        this.image = image;

    }
}
*/