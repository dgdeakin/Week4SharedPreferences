package com.application.week4sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    //Todo STEP 1: Button, EditText, CheckBox etc. Variables


    Button mbutton;

    SharedPreferences sharedPreferences;
    EditText myEditText, myPassword;
    CheckBox myCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Todo STEP 2: FindViewBy ID
        mbutton = findViewById(R.id.button);
        myEditText = findViewById(R.id.editTextTextPersonName);
        myCheckBox = findViewById(R.id.checkBox);
        myPassword = findViewById(R.id.editTextTextPassword);

        sharedPreferences = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);

        //Getting value of key "name" from sharedpreference
        String valueFromSharedPreference = sharedPreferences.getString("name", "");
        Log.v("Value from SharedPReferences", valueFromSharedPreference);

        myEditText.setText(valueFromSharedPreference);

        //Todo STEP 6: Get Values from Shared preferences
        String userName = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");


        //Todo Step 7: Update those values to EditTExt and Password Field
        myEditText.setText(userName);
        myPassword.setText(password);


        //Todo STep 8: Got to Welcome Activity if user already save the username and password.
//       if valuefrom shareprefece is sometthing?????
//        start activity with Intent.
        if (userName != ""){
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
        }



        //Todo STEP 3: Button On Click LIsternete
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor myEditor = sharedPreferences.edit();

                if(myCheckBox.isChecked()){


                    Log.v("Button Clicked","Button Clicked");
                    //Todo: Step 4: Grab Values from EditText and Password
                    String userName = myEditText.getText().toString();
                    String password = myPassword.getText().toString();
                    myEditor.putString("name", "My Name Is This");
                    myEditor.putString("username",  userName);
                    myEditor.putString("password", password);

                    //Todo: Step 5: Store those values using Editor
                    myEditor.apply();

                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                }
                else {
                    myEditor.putString("name", "");
                    myEditor.putString("username",  "");
                    myEditor.putString("password", "");
                    myEditor.apply();
                }




            }
        });








    }
}