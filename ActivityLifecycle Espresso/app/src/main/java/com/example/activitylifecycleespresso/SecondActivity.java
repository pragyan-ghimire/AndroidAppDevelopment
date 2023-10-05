package com.example.activitylifecycleespresso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG=SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY="com.example.android.activitylifecycleespresso.extra.REPLY";
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView=findViewById(R.id.text_message);
        textView.setText(message);
        mReply=(EditText) findViewById(R.id.editText_second);
        Log.d(LOG_TAG, "--------");
        Log.d(LOG_TAG, "onCreate");
    }

    public void returnReply(View view) {
    String reply=mReply.getText().toString();
    Intent replyIntent= new Intent();
    replyIntent.putExtra(EXTRA_REPLY,reply);
    setResult(RESULT_OK,replyIntent);
        Log.d(LOG_TAG, "End second activity ");
    finish();
    }



}