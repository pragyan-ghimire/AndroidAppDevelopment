package com.example.recyclerviewrecipie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    LinkedList<RecipeListStructure> mRecipeList = new LinkedList<>();
    int[] image={R.drawable.lemon_sandwiches,R.drawable.chocolate_mousse_cake,R.drawable.italian_grilled_cheese,
    R.drawable.mango_lime_bean_salad,R.drawable.momo,R.drawable.pizza};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        mRecipeList.addLast(new RecipeListStructure(getString(R.string.lemon_sandwiches),getString(R.string.lemon_sandwiches_description)));
        mRecipeList.addLast(new RecipeListStructure(getString(R.string.chocolate_mousse_cake),getString(R.string.chocolate_mousse_cake_description)));
        mRecipeList.addLast(new RecipeListStructure(getString(R.string.italian_grilled_cheese_sandwich),getString(R.string.italian_grilled_cheese_sandwich_description)));
        mRecipeList.addLast(new RecipeListStructure(getString(R.string.mango_black_bean_salad),getString(R.string.mango_black_bean_salad_description)));
        mRecipeList.addLast(new RecipeListStructure(getString(R.string.momo), getString(R.string.momo_description)));
        mRecipeList.addLast(new RecipeListStructure(getString(R.string.Pizza),getString(R.string.Pizza_description)));
        RecipeListAdapter adapter=new RecipeListAdapter(this,mRecipeList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void itemOnClick(int position) {
        Intent intent= new Intent(this,MainRecipe.class);
        intent.putExtra("IMAGE",image[position]);
        startActivity(intent);

    }
}