package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mScore1;
    private int mScore2;
    private TextView mScoreText1;
    private TextView mScoreText2;
    static final String STATE_SCORE_1="Team 1 Score";
    static final String STATE_SCORE_2="Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mScoreText1 =findViewById(R.id.score1);
         mScoreText2 =findViewById(R.id.score2);


         if (savedInstanceState!=null){
             mScore1=savedInstanceState.getInt(STATE_SCORE_1);
             mScore2=savedInstanceState.getInt(STATE_SCORE_2);
             mScoreText1.setText(String.valueOf(mScore1));
             mScoreText2.setText(String.valueOf(mScore2));
         }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SCORE_1,mScore1);
        outState.putInt(STATE_SCORE_2,mScore2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        //change the label of menu based on the state of the app
        int nightMode= AppCompatDelegate.getDefaultNightMode();
        if (nightMode==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.night_mode){
            //get night mode state of app
            int nightMode= AppCompatDelegate.getDefaultNightMode();
            //set the theme mode for the restarted Activity
            if (nightMode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            //recreate the activity for theme change to take effect
            recreate();
        }

        return super.onOptionsItemSelected(item);
    }

    public void increaseScore(View view) {
       switch (view.getId()){
           case R.id.increaseTeam1:
               mScore1++;
               mScoreText1.setText(String.valueOf(mScore1));
               break;
           case R.id.increaseTeam2:
               mScore2++;
               mScoreText2.setText(String.valueOf(mScore2));
               break;
       }
    }

    public void decreaseScore(View view) {
        switch (view.getId()){
            case R.id.decreaseTeam1:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }
}