package com.example.devicemanagement;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.devicemanagement.ui.Devices.DevicesViewModel;
import com.google.firebase.Firebase;
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

    private static int maxId = 0;

    final static String dbUrl = "https://device-management-a2f26-default-rtdb.europe-west1.firebasedatabase.app/";
    final static String pathStringDevices = "devices";
    final static String pathStringObjects = "objects";
    static DatabaseReference mDatabase;

    public static void setUpDatabase() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        mDatabase = FirebaseDatabase.getInstance(dbUrl).getReference();

        DatabaseReference devicesReference = mDatabase.child(pathStringDevices);
        DatabaseReference objectsReference = mDatabase.child(pathStringObjects);

/*
        for (int i = 1; i <= 20; i++) {
            Device d = new Device(i, "nameOfDevice" + i, "descriptionOfDevice" + i);
            String id = String.valueOf(d.getId());
            mDatabase.child(pathStringDevices).child(id).setValue(d);
        }
*/

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<Device> devices = new ArrayList<>();

                for (DataSnapshot deviceSnapshot : dataSnapshot.getChildren()) {
                    try {
                        Device device = deviceSnapshot.getValue(Device.class);
                        maxId = Math.max(maxId, device.getId());
                        devices.add(device);
                    }
                    catch (Exception e) {
                        Log.e(TAG, "onDataChange: ", e);
                    }
                }
                DevicesViewModel.setDeviceListLiveData(devices);

                Log.i("maxId", "Max ID onDataChange: " + maxId);

                // TODO: objects
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadDevice:onCancelled", databaseError.toException());
            }
        };
        devicesReference.addValueEventListener(valueEventListener);
        // TODO: objects
        //  objectsReference.addValueEventListener(valueEventListener);
    }

   public boolean saveDevice(Device device) {
       DatabaseReference databaseReference = mDatabase.child(pathStringDevices);
       try  {
           int id = device.getId();
           if (id == 0) {
               id = ++maxId;
               device.setId(id);
           }
           String key = String.valueOf(device.getId());
           databaseReference.child(key).setValue(device);
           return true;
       } catch (Exception e) {
           Log.e(TAG, "saveDevice: ", e);
           return false;
       }
   }
}
