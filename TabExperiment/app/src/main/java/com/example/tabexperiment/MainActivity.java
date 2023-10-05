package com.example.tabexperiment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewPager);

        //creating object of ViewPagerMessengerAdapter class
        ViewPagerMessengerAdapter adapter=new ViewPagerMessengerAdapter(getSupportFragmentManager());
        //setting up viewPager with adapter
        viewPager.setAdapter(adapter);

        //synchronizing tab and viewPager
        tab.setupWithViewPager(viewPager);
    }
}