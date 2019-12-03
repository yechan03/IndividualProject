package com.example.individualproject.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.individualproject.MedicineActivity;
import com.example.individualproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends Fragment {

    TextView Fever,Inflammation,cold,headache;






    public ChoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_choice, container, false);
        Context context = getContext();

        Fever = view.findViewById(R.id.Fever);
        Inflammation = view.findViewById(R.id.Inflammation);
        cold = view.findViewById(R.id.cold);
        headache = view.findViewById(R.id.headache);

        final Intent intent = new Intent(context, MedicineActivity.class);

        Fever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("medicine","Fever");
                startActivity(intent);

            }
        });


        Inflammation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("medicine","Inflammation");
                startActivity(intent);
            }
        });


        cold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("medicine","cold");
                startActivity(intent);
            }
        });

        headache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("medicine","headache");
                startActivity(intent);
            }
        });


        return view;
    }


}
