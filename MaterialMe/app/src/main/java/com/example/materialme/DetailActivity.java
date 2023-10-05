package com.example.materialme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView title, subTitle;
    private ImageView imageSport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title=findViewById(R.id.titleDetail);
        imageSport=findViewById(R.id.imageSportsDetail);
        subTitle=findViewById(R.id.subTitleDetail);
        title.setText(getIntent().getStringExtra("TITLE"));
        Glide.with(this).load(getIntent().getIntExtra("IMAGE",0)).into(imageSport);
        subTitle.setText(getIntent().getStringExtra("DESCRIPTION"));
    }
}