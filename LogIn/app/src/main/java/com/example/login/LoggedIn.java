package com.example.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LoggedIn extends AppCompatActivity {
    private static final int pic_id=123;
    private ImageView captured_photo;
    private TextView photo_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        captured_photo=findViewById(R.id.imageView);
        photo_text=findViewById(R.id.textView);
    }

    public void openCamera(View view) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,pic_id);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==pic_id){
            if (resultCode==RESULT_OK){
                //Bitmap is data structure of image file which store the image in memory
                Bitmap photo= (Bitmap) data.getParcelableExtra("data");
//                Bitmap photo =(Bitmap) data.getExtras().get("data");
                //set image in imageView for display
                captured_photo.setImageBitmap(photo);

                photo_text.setVisibility(View.INVISIBLE);

            }
        }
    }
}