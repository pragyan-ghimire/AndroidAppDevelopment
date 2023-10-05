package com.example.login;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mMobileNum;
    private EditText mPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.status)));
//        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.status));
        mMobileNum=findViewById(R.id.editText_mobile_num);
        mPassword=findViewById(R.id.editText_password);
    }

    public void logIn(View view) {
        String mobileNumber=mMobileNum.getText().toString();
        String password=mPassword.getText().toString();
        if(mobileNumber.equals("9804313270")&& password.equals("admin")){
            Intent intent=new Intent(this,LoggedIn.class);
            startActivity(intent);
        }
        else if(mobileNumber.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Please enter mobile number and password.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Invalid mobile number or password.", Toast.LENGTH_SHORT).show();
        }
    }

    public void registerNow(View view) {
        Intent register_intent=new Intent(this,RegisterActivity.class);
        startActivity(register_intent);
    }
}