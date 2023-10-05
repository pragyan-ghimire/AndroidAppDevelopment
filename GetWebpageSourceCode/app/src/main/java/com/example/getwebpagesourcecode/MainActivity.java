package com.example.getwebpagesourcecode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, LoaderManager.LoaderCallbacks<String> {
    public static String TAG=MainActivity.class.getSimpleName();
    private static final int WEB_CONTENT_LOADER_ID = 1;
    private EditText webpage;
    private TextView source_code;
    String spinnerLabel;
    String mUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        webpage=findViewById(R.id.et_webpage);
        source_code=findViewById(R.id.tv_source_code);



        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.protocol_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if(spinner !=null){
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }

        if(getSupportLoaderManager().getLoader(WEB_CONTENT_LOADER_ID)!=null){
           getSupportLoaderManager().initLoader(WEB_CONTENT_LOADER_ID,null,this);
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinnerLabel=adapterView.getItemAtPosition(i).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    public void getCode(View view) {
        mUrl=spinnerLabel+webpage.getText().toString();
        Log.d(TAG, mUrl);

        InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if(inputMethodManager!=null){
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=null;
        if (connectivityManager!=null){
            networkInfo=connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo!=null && networkInfo.isConnected() && webpage.getText().toString().length()!=0){
            source_code.setText(R.string.loading);
            LoaderManager.getInstance(this).initLoader(WEB_CONTENT_LOADER_ID, null, this).forceLoad();
        }else if(webpage.getText().toString().length()==0){
            source_code.setText(R.string.noUrl_text);
        }else{
            source_code.setText(R.string.check_internet);
        }

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {

        return new SourceCodeLoader(this,mUrl);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        source_code.setText(data);
        Log.d(TAG, data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}