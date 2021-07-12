package com.example.notepadapp.Model.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notepadapp.R;

public class Initial_fragment extends Fragment {

    AppCompatButton getStartedButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.initial_fragment, container, false);
        getStartedButton = (AppCompatButton) view.findViewById(R.id.getStartedButtonID);

        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).replace(R.id.frame_container, new Login_fragment()).addToBackStack(null).commit();

            }
        });
        return view;
    }
}