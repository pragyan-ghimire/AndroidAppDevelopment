package com.example.activitychallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_CONTENT = "com.example.android.activitychallenge.extra.CONTENT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchCoding(View view) {
        String message = getString(R.string.text_one);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_CONTENT, message);
        startActivity(intent);
    }

    public void launchGaming(View view) {
        String message = getString(R.string.text_two);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_CONTENT, message);
        startActivity(intent);
    }

    public void launchEntertainment(View view) {
        String message = getString(R.string.text_three);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_CONTENT, message);
        startActivity(intent);
    }
}