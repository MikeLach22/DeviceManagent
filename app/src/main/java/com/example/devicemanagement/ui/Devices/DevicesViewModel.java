package com.example.devicemanagement.ui.Devices;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.devicemanagement.Device;

import java.util.ArrayList;
import java.util.List;

public class DevicesViewModel extends ViewModel {
    private static MutableLiveData<List<Device>> deviceListLiveData = new MutableLiveData<>();

    public LiveData<List<Device>> getDeviceListLiveData() {
        return deviceListLiveData;
    }

    public static void setDeviceListLiveData(List<Device> devices) {
        deviceListLiveData.setValue(devices);
        Log.i("DevicesViewModel", "setDeviceListLiveData: " + devices);
    }
}

