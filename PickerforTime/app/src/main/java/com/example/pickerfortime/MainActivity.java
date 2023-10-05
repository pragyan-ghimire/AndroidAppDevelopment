package com.example.pickerfortime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment= new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),"time picker");
    }

    public void processTimePicker(int hourOfDay, int minute){
        String hourOfDay_string=Integer.toString(hourOfDay);
        String minute_string=Integer.toString(minute);
        String time_message=hourOfDay_string+":"+minute_string;
        Toast.makeText(this, "Time= "+time_message, Toast.LENGTH_SHORT).show();
    }
}