package com.example.implicitintentsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//worked on moms phone
        Intent intent=getIntent();
        Uri uri=intent.getData();
        if (uri!=null){
            Log.d("receiver", "received");
            String uri_string=getString(R.string.uri_label)+uri.toString();
            TextView textView=findViewById(R.id.text_uri_message);
            textView.setText(uri_string);
        }
        else {
            Log.d("receiver", "onCreate: failed");
        }
    }
}