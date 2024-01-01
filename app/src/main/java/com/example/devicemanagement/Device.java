package com.example.devicemanagement;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Device implements Parcelable {
    // Metadata:
    private int id;
    private String name;
    private String description;
    /*
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

     */


    public Device() {
        // Leerer Konstruktor wird von Firebase benötigt
    }


    public Device(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /*
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
     */

    protected Device(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        // Weitere Felder hier...
    }

    // Creator für die Parcelable-Erstellung
    public static final Parcelable.Creator<Device> CREATOR = new Parcelable.Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel in) {
            return new Device(in);
        }

        @Override
        public Device[] newArray(int size) {
            return new Device[size];
        }
    };

    // describeContents-Methode - gibt 0 zurück, es sei denn, es gibt spezielle Objekte im Parcel
    @Override
    public int describeContents() {
        return 0;
    }

    // writeToParcel-Methode - schreibt die Daten in das Parcel
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        // Weitere Felder hier...
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
/*
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
*/
    // TODO: Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean addDeviceToDatabase() {
        Database database = new Database();
        return database.saveDevice(this);
    }

}