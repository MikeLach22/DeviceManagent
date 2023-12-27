package com.example.devicemanagement.ui.AddDevice;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.devicemanagement.R;

import java.util.Calendar;

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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_device, container, false);

        Button selectDateButton = view.findViewById(R.id.datepicker);
        TextView date = view.findViewById(R.id.date);
        date.setText("No Date Selected");
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
                                                        date.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
                                                    }
                }, year, month, day);
                picker.show();
            }
        });

        //         btnChangeDate = (Button) findViewById(R.id.dateButton);
        //        btnChangeDate.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                final Calendar cldr = Calendar.getInstance();
        //                int day = cldr.get(Calendar.DAY_OF_MONTH);
        //                int month = cldr.get(Calendar.MONTH);
        //                int year = cldr.get(Calendar.YEAR);
        //                // date picker dialog
        //                picker = new DatePickerDialog(MainActivity.this,
        //                        new DatePickerDialog.OnDateSetListener() {
        //                            @Override
        //                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //                                btnChangeDate.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
        //                            }
        //                        }, year, month, day);
        //                picker.show();
        //            }
        //        });


        // Save Button:
        Button saveButton = view.findViewById(R.id.button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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