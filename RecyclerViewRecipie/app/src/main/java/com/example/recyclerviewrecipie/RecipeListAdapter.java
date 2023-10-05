package com.example.recyclerviewrecipie;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;


public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    RecyclerViewInterface recyclerViewInterface;
     LinkedList<RecipeListStructure> mRecipeList;

     LayoutInflater mInflater;


    public RecipeListAdapter(Context context,LinkedList<RecipeListStructure> recipeList, RecyclerViewInterface recyclerViewInterface1){ // context can be taken from activity class
        this.mInflater=LayoutInflater.from(context);
        this.mRecipeList=recipeList;
        this.recyclerViewInterface=recyclerViewInterface1;


    }
    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.recipe_list,parent,false);// to inflate
        return new RecipeViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {// To set text, img ,....... in different position
        // we will take from dataset(LinkedList)
        holder.recipe_heading.setText(mRecipeList.get(position).txtHeading);
        holder.recipe_description.setText(mRecipeList.get(position).txtDescription);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView recipe_heading;
        TextView recipe_description;

        public RecipeViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {// find ids
            super(itemView);
            recipe_heading=itemView.findViewById(R.id.textView_recipeHeading);
            recipe_description=itemView.findViewById(R.id.textView_recipeShortDescription);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=getAdapterPosition();
                    recyclerViewInterface.itemOnClick(pos);

                }
            });
        }
    }
}
