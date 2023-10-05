package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG=MainActivity.class.getSimpleName();
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText=findViewById(R.id.website_editText);
        mLocationEditText=findViewById(R.id.location_editText);
        mShareTextEditText=findViewById(R.id.share_editText);
    }


    //if intent.resolveActivity.......is not checked it runs on API 30 or higher API android 11
    //even if it is checked it still runs on API 29 or lower API
    public void openWebsite(View view) {
        //get url text
        String url=mWebsiteEditText.getText().toString();

        //parse the uri and create intent
        Uri webpage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,webpage);

        //find the activity to handle the intent and startActivity
//        if(intent.resolveActivity(getPackageManager())!=null){
//            startActivity(intent);
//        }
//        else {
//            Log.d("ImplicitIntents", "openWebsite:can't handle this ");
//        }
        //create intent to show chooser
//        Intent chooser =Intent.createChooser(intent,"choose app:");
        try {
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Log.d("ImplicitIntents", "openWebsite: can't handle");
        }
    }


    public void openLocation(View view) {
        //get string indicating a location. Input is not validated. It is passed to the location handler intact
        String loc=mLocationEditText.getText().toString();

        //parse the location and create intent.
        Uri addressUri=Uri.parse("geo:0,0?q="+loc);
        Intent intent=new Intent(Intent.ACTION_VIEW,addressUri);

        //find the activity to handle the intent and startActivity
//        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
//        }
//        else{
//            Log.d("ImplicitIntents", "openLocation:can't handle ");
//        }

    }

    public void openShare(View view) {
        String txt=mShareTextEditText.getText().toString();
        String mimeType="text/plain";//mediaType or content type
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();

    }

    public void takePicture(View view) {
        Intent capture_pic=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivity(capture_pic);
        }
        catch (ActivityNotFoundException e){
            Log.e(LOG_TAG, "takePicture: failed", e);
        }
    }
}