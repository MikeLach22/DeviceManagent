package com.example.devicemanagement.ui.Devices;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.devicemanagement.Device;
import com.example.devicemanagement.R;

import java.util.List;
public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.ViewHolder> {
    private List<String> list;
    private List<Device> deviceList;

    /* public DevicesAdapter(List<String> list) {
        this.list = list;
    } */
    
    public DevicesAdapter(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_devices, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
/*
        String deviceName = list.get(position);
        holder.devicesItemName.setText(deviceName);
 */
        Device device = deviceList.get(position);
        holder.devicesItemName.setText(device.getName());
        holder.devicesItemDescription.setText(device.getDescription());
    }

    @Override
    public int getItemCount() {
        // return list.size();
        return deviceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView devicesItemName;
        public TextView devicesItemDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            devicesItemName = itemView.findViewById(R.id.DevicesItemName);
            devicesItemDescription = itemView.findViewById(R.id.DevicesItemDescription);
        }
    }
}