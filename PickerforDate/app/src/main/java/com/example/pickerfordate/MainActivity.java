package com.example.pickerfordate;

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

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }
    public void processDataPickerResult(int year, int month, int day){
        String month_string=Integer.toString(month+1);//0 as january
        String day_string=Integer.toString(day);
        String year_string=Integer.toString(year);
        String dateMessage=(month_string+"/"+day_string+"/"+year_string);
        Toast.makeText(this, getString(R.string.date)+dateMessage, Toast.LENGTH_SHORT).show();
    }
}