package com.example.notepadapp.Model.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.notepadapp.Model.Fragment.Initial_fragment;
import com.example.notepadapp.Model.Fragment.Login_fragment;
import com.example.notepadapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Initial_fragment()).commit();

        }
    }
}