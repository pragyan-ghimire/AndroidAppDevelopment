package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Items extends AppCompatActivity {
public static final String LOG_TAG=Items.class.getSimpleName();
public static int count=1;
public static final String EXTRA_ITEM="com.example.android.shoppinglist.extra.ITEM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
    }

    public void chosenItem(View view) {
        count++;
        Log.d(LOG_TAG, Integer.toString(count));
        Button b=(Button) view;
      String item=b.getText().toString();
        Log.d(LOG_TAG, item);
        Intent returnItem = new Intent();
        returnItem.putExtra(EXTRA_ITEM,item);
        setResult(RESULT_OK,returnItem);
        finish();

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause: ");
    }
}