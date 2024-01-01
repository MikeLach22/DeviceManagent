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
    private List<Device> deviceList;
    public DevicesAdapter(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    private DevicesItemClickInterface clickListener;
    public void setClickListener(DevicesItemClickInterface clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_devices, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Device device = deviceList.get(position);
        holder.devicesItemName.setText(device.getName());
        holder.devicesItemDescription.setText(device.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();
                if (clickedPosition != RecyclerView.NO_POSITION && clickListener != null) {
                    clickListener.onItemClick(clickedPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
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