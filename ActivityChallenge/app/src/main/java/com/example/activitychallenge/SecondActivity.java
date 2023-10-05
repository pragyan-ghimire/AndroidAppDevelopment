package com.example.activitychallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        TextView sTextContent = findViewById(R.id.text_content);
        String text = intent.getStringExtra(MainActivity.EXTRA_CONTENT);
        sTextContent.setText(text);


    }
}