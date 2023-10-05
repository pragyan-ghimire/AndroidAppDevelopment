package com.example.firstapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public void clickBtn(View view){
        EditText username= findViewById(R.id.username);
        EditText password= findViewById(R.id.password);

        String name=username.getText().toString();
        String pass=password.getText().toString();

        if(name.equals("admin")&& pass.equals("admin")){
            Toast.makeText(this, "Log in successful", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","Hello World");
    }
}