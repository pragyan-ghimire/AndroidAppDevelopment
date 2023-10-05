package com.example.recyclerviewrecipie;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainRecipe extends AppCompatActivity {
        ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recipe);
        imageView=findViewById(R.id.imageView);
        Intent intent=getIntent();
        int image=intent.getIntExtra("IMAGE",0);
        imageView.setImageResource(image);

    }
}