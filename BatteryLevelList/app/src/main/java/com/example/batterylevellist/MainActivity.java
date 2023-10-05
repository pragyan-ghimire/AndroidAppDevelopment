package com.example.batterylevellist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mLevel=0;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         imageView=findViewById(R.id.imageViewBattery);

    }

    public void batteryDecrease(View view) {
        mLevel--;

        if (mLevel<0){
            Toast.makeText(this, "Please charge(click +)", Toast.LENGTH_SHORT).show();
            mLevel=0;
        }
        else{
            imageView.setImageLevel(mLevel);
        }

    }

    public void batteryIncrease(View view) {
        mLevel++;
        if (mLevel>7){
            Toast.makeText(this, "Full charged", Toast.LENGTH_SHORT).show();
            mLevel=7;
        }
        else{
            imageView.setImageLevel(mLevel);
        }
    }
}