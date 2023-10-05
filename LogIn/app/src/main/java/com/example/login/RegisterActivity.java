package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    private EditText rMobileNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rMobileNumber=findViewById(R.id.reg_editText_mobile_num);
        Spinner spinner=findViewById(R.id.spinner_occupation);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.occupation_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
        if (rMobileNumber != null) {
            rMobileNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean handled=false;
                    if (i==EditorInfo.IME_ACTION_SEND){
                        dialNumber();
                        handled=true;
                    }
                    return handled;
                }
            });
        }
    }
    public void dialNumber(){
        rMobileNumber=findViewById(R.id.reg_editText_mobile_num);
        String phoneNumber=null;
        if(rMobileNumber!=null){
            phoneNumber="tel:"+rMobileNumber.getText().toString();
        }
        Uri uri=Uri.parse(phoneNumber);
        Intent dial_intent=new Intent(Intent.ACTION_DIAL,uri);
        try {
            startActivity(dial_intent);
        }
        catch (ActivityNotFoundException e){
            Log.d("ImplicitIntent", "dialNumber: failed ");
        }

    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String spinnerLabel=adapterView.getItemAtPosition(i).toString(); retrieving spinner item
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}