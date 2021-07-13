package com.example.notepadapp.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.notepadapp.View.Fragment.Initial_fragment;
import com.example.notepadapp.R;
import com.example.notepadapp.View.Fragment.Login_fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Login_fragment()).commit();

        }
    }
}