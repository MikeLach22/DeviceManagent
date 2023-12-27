package com.example.devicemanagement.ui.Devices;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.devicemanagement.Device;
import com.example.devicemanagement.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DevicesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DevicesFragment extends Fragment {

    public DevicesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DevicesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DevicesFragment newInstance(String param1, String param2) {
        DevicesFragment fragment = new DevicesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_devices, container, false);

        List<Device> deviceArrayList = new ArrayList<>();

        DevicesViewModel devicesViewModel = new ViewModelProvider(requireActivity()).get(DevicesViewModel.class);
        devicesViewModel.getDeviceListLiveData().observe(getActivity(), deviceArrayList::addAll);

        RecyclerView recyclerView = view.findViewById(R.id.devices_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        DevicesAdapter deviceNamesAdapter = new DevicesAdapter(deviceArrayList);
        recyclerView.setAdapter(deviceNamesAdapter);


        // Action Button:
        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.floatingActionButton)
                        .setAction("Action", null).show();
                */
                NavHostFragment.findNavController(DevicesFragment.this)
                        .navigate(R.id.action_navigation_devices_to_addDeviceFragment);
            }
        });

        return view;
    }



}