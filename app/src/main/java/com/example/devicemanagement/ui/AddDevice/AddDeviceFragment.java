package com.example.devicemanagement.ui.AddDevice;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.devicemanagement.Device;
import com.example.devicemanagement.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddDeviceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDeviceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Device deviceToEdit;
    private Device newDevice;


    public AddDeviceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddDeviceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddDeviceFragment newInstance(String param1, String param2) {
        AddDeviceFragment fragment = new AddDeviceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            this.deviceToEdit = getArguments().getParcelable("deviceToEdit");
            if (deviceToEdit != null) {
                Log.i("TAG", "Device to edit: " + deviceToEdit.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_device, container, false);

        EditText editTextName = view.findViewById(R.id.editTextName);
        EditText editTextDescription = view.findViewById(R.id.editTextDescription);
/*
        Date date = new Date();
        Button selectDateButton = view.findViewById(R.id.datepicker);
        TextView dateView = view.findViewById(R.id.date);
        dateView.setText(date.toString());

        selectDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                DatePickerDialog picker = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            dateView.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
                        }
                    }, year, month, day);
                picker.show();
            }
        });
*/

        if (deviceToEdit != null) {
            ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(getString(R.string.title_edit_device));
            }

            editTextName.setText(deviceToEdit.getName());
            editTextDescription.setText(deviceToEdit.getDescription());
        }

        // Cancel Button:
        Button cancelButton = view.findViewById(R.id.addDeviceCancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AddDeviceFragment.this)
                        .navigate(R.id.action_addDeviceFragment_to_navigation_devices);
            }
        });


        // Save Button:
        Button saveButton = view.findViewById(R.id.addDeviceSaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = deviceToEdit != null ? deviceToEdit.getId() : 0;
                String name = String.valueOf(editTextName.getText());
                String description = String.valueOf(editTextDescription.getText());

                newDevice = new Device(id, name, description);

                String savedMsg;
                if (newDevice.addDeviceToDatabase()) {
                    savedMsg = getString(R.string.pop_device_saved) + " '" + name + "'";
                } else {
                    savedMsg = getString(R.string.pop_device_fail) + " '" + name + "'";
                }

                Snackbar.make(view, savedMsg, Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.nav_view)
                        .setAction("Action", null).show();

                NavHostFragment.findNavController(AddDeviceFragment.this)
                        .navigate(R.id.action_addDeviceFragment_to_navigation_devices);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}