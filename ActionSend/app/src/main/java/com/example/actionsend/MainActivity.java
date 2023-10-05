package com.example.actionsend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public static final String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editText_phone_number);
        if(editText!=null){
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean handled=false;
                    if(i== EditorInfo.IME_ACTION_SEND){//here i is actionId
                        dialNumber();
                        handled=true;
                    }
                    return handled;
                }
            });
        }
    }
    public void dialNumber(){
        EditText editText = findViewById(R.id.editText_phone_number);
        String phoneNum=null;

        if(editText!=null){
            phoneNum="tel:"+editText.getText().toString();
        }
        Log.d(TAG, "dialNumber: "+phoneNum);
//        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse(phoneNum));
        Intent intent =new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phoneNum));
        try {
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Log.d(TAG, "dialNumber: not found");
        }

    }
}