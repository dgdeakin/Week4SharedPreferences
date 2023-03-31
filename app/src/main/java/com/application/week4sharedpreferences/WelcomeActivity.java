package com.application.week4sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    //TODO STEP 1 : Create variable
    SharedPreferences returnSharedValue;
    TextView myTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        //Todo STEP 2: Find View By Id

        myTextView = findViewById(R.id.textView2);

        ///Todo STep 3: Get SharedPreference

        returnSharedValue = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);
        String returnValue = returnSharedValue.getString("username", "");

        //Todo STep 4: Set Text with Name
        myTextView.setText("Welcome to the app \n" +returnValue);
    }
}