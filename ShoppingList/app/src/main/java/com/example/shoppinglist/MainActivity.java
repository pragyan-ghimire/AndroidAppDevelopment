package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG=MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST=1;

    private TextView itemOne;
    private TextView itemTwo;
    private TextView itemThree;
    private TextView itemFour;
    private TextView itemFive;
    private TextView itemSix;
    private TextView itemSeven;
    private TextView itemEight;
    private TextView itemNine;
    private TextView itemTen;
    private EditText searchEditText;
    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize textviews
        itemOne=findViewById(R.id.textView1);
        itemTwo =findViewById(R.id.textView2);
        itemThree=findViewById(R.id.textView3);
        itemFour=findViewById(R.id.textView4);
        itemFive=findViewById(R.id.textView5);
        itemSix=findViewById(R.id.textView6);
        itemSeven=findViewById(R.id.textView7);
        itemEight=findViewById(R.id.textView8);
        itemNine=findViewById(R.id.textView9);
        itemTen=findViewById(R.id.textView10);

        searchEditText=findViewById(R.id.editText_search);

        if(savedInstanceState!=null){
            boolean isSelected=savedInstanceState.getBoolean("item");
            if(isSelected){
                itemOne.setText(savedInstanceState.getString("itemOne"));
                itemTwo.setText(savedInstanceState.getString("itemTwo"));
                itemThree.setText(savedInstanceState.getString("itemThree"));
                itemFour.setText(savedInstanceState.getString("itemFour"));
                itemFive.setText(savedInstanceState.getString("itemFive"));
                itemSix.setText(savedInstanceState.getString("itemSix"));
                itemSeven.setText(savedInstanceState.getString("itemSeven"));
                itemEight.setText(savedInstanceState.getString("itemEight"));
                itemNine.setText(savedInstanceState.getString("itemNine"));
                itemTen.setText(savedInstanceState.getString("itemTen"));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(Integer.toString(count)!=null){
            outState.putBoolean("item",true);
            outState.putString("itemOne",itemOne.getText().toString());
            outState.putString("itemTwo", itemTwo.getText().toString());
            outState.putString("itemThree",itemThree.getText().toString());
            outState.putString("itemFour",itemFour.getText().toString());
            outState.putString("itemFive",itemFive.getText().toString());
            outState.putString("itemSix",itemSix.getText().toString());
            outState.putString("itemSeven",itemSeven.getText().toString());
            outState.putString("itemEight",itemEight.getText().toString());
            outState.putString("itemNine",itemNine.getText().toString());
            outState.putString("itemTen",itemTen.getText().toString());
        }
    }

    public void addItem(View view) {
        //count takes initial value of Items.count
          count=Items.count;
//        count++;
        Log.d(LOG_TAG, Integer.toString(count));
        Intent intent=new Intent(this,Items.class);
        startActivityForResult(intent,TEXT_REQUEST);
    }
    public void searchStore(View view) {
        String loc=searchEditText.getText().toString();
        Uri uri = Uri.parse("geo:0,0?q="+loc);
        Intent searchIntent=new Intent(Intent.ACTION_VIEW,uri);
        try {
            startActivity(searchIntent);
        }
        catch (ActivityNotFoundException e){
            Log.d("search", "searchStore: searchFailed");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==TEXT_REQUEST){
            if (resultCode==RESULT_OK){
                String itemChosen=data.getStringExtra(Items.EXTRA_ITEM);
                switch (count){
                    case 1:
                        itemOne.setText(itemChosen);
                        break;
                    case 2:
                        itemTwo.setText(itemChosen);
                        break;
                    case 3:
                        itemThree.setText(itemChosen);
                        break;
                    case 4:
                        itemFour.setText(itemChosen);
                        break;
                    case 5:
                        itemFive.setText(itemChosen);
                        break;
                    case 6:
                        itemSix.setText(itemChosen);
                        break;
                    case 7:
                        itemSeven.setText(itemChosen);
                        break;
                    case 8:
                        itemEight.setText(itemChosen);
                        break;
                    case 9:
                        itemNine.setText(itemChosen);
                        break;
                    case 10:
                        itemTen.setText(itemChosen);
                        break;
                }
            }
        }
    }


}