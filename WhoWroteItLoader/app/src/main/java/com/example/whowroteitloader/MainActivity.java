package com.example.whowroteitloader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
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

        if(getSupportLoaderManager().getLoader(0) !=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
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
           Bundle queryBundle= new Bundle();
           queryBundle.putString("queryString",queryString);
           getSupportLoaderManager().restartLoader(0,queryBundle,this);
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

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString="";
        if(args!=null){
            queryString=args.getString("queryString");
        }
        return new BookLoader(this,queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try{
            // Convert the response into a JSON object.
            JSONObject jsonObject= new JSONObject(data);
            // Get the JSONArray of book items.
            JSONArray itemsArray=jsonObject.getJSONArray("items");

            // Initialize iterator and results fields.
            int i=0;
            String title=null;
            String authors=null;


            // Look for results in the items array, exiting
            // when both the title and author
            // are found or when all items have been checked.

            while (i<itemsArray.length()&&(title==null&&authors==null)){
                // Get the current item information.
                JSONObject book= itemsArray.getJSONObject(i);
                JSONObject volumeInfo=book.getJSONObject("volumeInfo");

                // Try to get the author and title from the current item,
                // catch if either field is empty and move on.
                try{
                    title=volumeInfo.getString("title");
                    authors=volumeInfo.getString("authors");
                }catch (JSONException e){
                    e.printStackTrace();
                }
                // Move to the next item.
                i++;
            }
            // If both are found, display the result.
            if(title!=null && authors!=null){
                mTitleText.setText(title);
                mAuthorText.setText(authors);
            }else{
                // If none are found, update the UI to
                // show failed results.
                mTitleText.setText(R.string.no_results);
                mAuthorText.setText("");
            }
        }catch (JSONException e){
            // If onPostExecute does not receive a proper JSON string,
            // update the UI to show failed results.
            mTitleText.setText(R.string.no_results);
            mAuthorText.setText("");
            e.printStackTrace();
        }
    }


    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}