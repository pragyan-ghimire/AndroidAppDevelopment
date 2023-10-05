package com.example.checkboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private String mShowToast="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //for displaying Toast
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),"Toppings: "+message,Toast.LENGTH_SHORT).show();
    }

    // CheckBox handler
    public void itemSelected(View view) {
        String message="";
//        CheckBox checkBox =(CheckBox) view;
//        if (checkBox.isChecked()){
//            message=checkBox.getText().toString();
//            mShowToast=mShowToast+" "+message;
//        }
        boolean checked=((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.checkBox:
                if (checked){
                    message=getString(R.string.chocolate_syrup);
                }
                break;
            case R.id.checkBox2:
                if (checked){
                    message=getString(R.string.sprinkles);
                }
                break;
            case R.id.checkBox3:
                if (checked){
                    message=getString(R.string.crushed_nuts);
                }
                break;
            case R.id.checkBox4:
                if (checked){
                    message=getString(R.string.cherries);
                }
                break;
            case R.id.checkBox5:
                if (checked){
                    message=getString(R.string.oreo_cookie_crumbles);
                }
                break;
        }
        mShowToast=mShowToast+" "+message;


    }
    //Show Toast button handler
    public void showToast(View view) {
        displayToast(mShowToast);
    }

}