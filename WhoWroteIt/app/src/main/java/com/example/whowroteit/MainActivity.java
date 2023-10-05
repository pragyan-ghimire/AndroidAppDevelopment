package com.example.whowroteit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mAuthorText;
    private TextView mTitleText;
    private EditText mBookInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput=findViewById(R.id.bookInput);
        mTitleText=findViewById(R.id.titleText);
        mAuthorText=findViewById(R.id.authorText);
    }

    public void searchBooks(View view) {
        String queryString=mBookInput.getText().toString();

        InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if(inputMethodManager!=null){
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }

        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=null;
        if(connectivityManager!=null){
            networkInfo=connectivityManager.getActiveNetworkInfo();
        }

        if(networkInfo!=null && networkInfo.isConnected() && queryString.length()!=0){
            new FetchBook(mTitleText,mAuthorText).execute(queryString);
            mTitleText.setText(R.string.loading);
            mAuthorText.setText("");
        }else {
            if(queryString.length()==0){
                mTitleText.setText(R.string.no_search_term);
                mAuthorText.setText("");
            }else {
                mTitleText.setText(R.string.no_network);
                mAuthorText.setText("");
            }
        }


    }
}