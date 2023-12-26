package com.example.devicemanagement;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.devicemanagement.ui.Devices.DevicesViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private MutableLiveData<List<Device>> deviceListLiveData = new MutableLiveData<>();

    public LiveData<List<Device>> getDeviceListLiveData() {
        // Hier wird die MutableLiveData als LiveData zurückgegeben, um externe Änderungen zu verhindern
        return deviceListLiveData;
    }

    final static String dbUrl = "https://device-management-a2f26-default-rtdb.europe-west1.firebasedatabase.app/";
    final static String pathStringDevices = "devices";
    final static String pathStringObjects = "objects";

    public static void setUpDatabase() {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance(dbUrl).getReference();

        DatabaseReference devicesReference = mDatabase.child(pathStringDevices);
        DatabaseReference objectsReference = mDatabase.child(pathStringObjects);

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<Device> devices = new ArrayList<>();
                for (int i = 1; i <= 20; i++) {
                    Device device = new Device(i, "nameOfDevice" + i, "descriptionOfDevice" + i);
                    devices.add(device);
                }
                DevicesViewModel.setDeviceListLiveData(devices);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadDevice:onCancelled", databaseError.toException());
            }
        };
        mDatabase.addValueEventListener(valueEventListener);
    }
}
