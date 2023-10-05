package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount=0;
    private TextView mShowCount;
    private Button zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount=(TextView) findViewById(R.id.show_count);
        zero =(Button) findViewById(R.id.count_initial);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        zero.setBackgroundColor(Color.RED);
        if(mShowCount!=null){
            mShowCount.setText(Integer.toString(mCount));
        }
        if(mCount%2==0){
            view.setBackgroundColor(Color.GREEN);
        }
        else{
            view.setBackgroundResource(R.color.purple_500);
        }

    }
    public void clickZero(View view) {
        mCount=0;
        view.setBackgroundResource(R.color.gray);
        if(mShowCount!=null){
            mShowCount.setText(Integer.toString(mCount));
        }


    }

}