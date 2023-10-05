package com.example.recyclerviewespresso;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> wordList){
        mInflater=LayoutInflater.from(context);
        this.mWordList=wordList;
    }
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView=mInflater.inflate(R.layout.wordlist_item,parent,false);
        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
    String mCurrent= mWordList.get(position);
    holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        final WordListAdapter mAdapter;
        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView=itemView.findViewById(R.id.word);
            this.mAdapter=adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //get position of item that was clicked
            int mPosition=getLayoutPosition();
            Log.d("ViewHolderAdapter", "position: "+mPosition);
            // use that to access affected item in mWordList
            String element=mWordList.get(mPosition);
            //change the word in mWordList
            mWordList.set(mPosition,"Clicked!"+element);
            //Notify the adapter that the data has been changed so it can
            //update the RecyclerView to display the data
            mAdapter.notifyDataSetChanged();
        }
    }
}
