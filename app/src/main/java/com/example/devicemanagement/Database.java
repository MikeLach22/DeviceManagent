package com.example.devicemanagement;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

    final static String dbUrl = "https://device-management-a2f26-default-rtdb.europe-west1.firebasedatabase.app/";
    final static String pathStringDevices = "devices";
    final static String pathStringObjects = "objects";

    public static void setUpDatabase() {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance(dbUrl).getReference();

        DatabaseReference devicesReference = mDatabase.child(pathStringDevices);
        DatabaseReference objectsReference = mDatabase.child(pathStringObjects);

/*
        for (int i = 1; i <= 20; i++) {
            Device d = new Device(i, "nameOfDevice" + i, "descriptionOfDevice" + i);
            String id = "device" + d.getId();
            mDatabase.child(pathStringDevices).child(id).setValue(d);
        }
*/

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<Device> devices = new ArrayList<>();
                for (int i = 1; i <= 20; i++) {
                    Device device = new Device(i, "nameOfDevice" + i, "descriptionOfDevice" + i);
                    devices.add(device);
                }
                /* TODO: use this
                **  deviceListLiveData.setValue(devices);
                */

                // Device device = dataSnapshot.getValue(Device.class);
                // Log.d(TAG, "Value is: " + device);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadDevice:onCancelled", databaseError.toException());
            }
        };
        mDatabase.addValueEventListener(valueEventListener);

        /*
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Device");
        myRef.setValue("Bye, World!");
        Device device = new Device("name", "description", "serialNumber", new Date(), 1, "maintenanceStatus", "locationOfDevice", "operatingInstructions", "contactPartner");
        myRef.setValue(device);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

         */
    }
}
