package com.example.customizetoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);

        //step 2
//        if(getSupportActionBar()!=null){
////            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//back button shown which takes to first activity, so enable in other than first activity
//            getSupportActionBar().setTitle("ToolBar");
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        new MenuInflater(this).inflate(R.menu.menu_main,menu);//this didn't show the icons
        getMenuInflater().inflate(R.menu.menu_main,menu);//this does
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_contact:
                Toast.makeText(this, "Pressed contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_saved:
                Toast.makeText(this, "Pressed saved", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_favorites:
                Toast.makeText(this, "Pressed favorites", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}