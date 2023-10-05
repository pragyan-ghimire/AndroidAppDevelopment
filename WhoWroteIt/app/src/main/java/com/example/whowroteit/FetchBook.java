package com.example.whowroteit;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;


/**
 * String because the query is a string, Void because there is no progress indicator,
 * and String because the JSON response is a string
 */
public class FetchBook extends AsyncTask<String,Void,String> {
    private WeakReference<TextView> mTitleText;
    private WeakReference<TextView> mAuthorText;

    FetchBook(TextView titleTextView, TextView authorTextView){
        this.mTitleText=new WeakReference<>(titleTextView);
        this.mAuthorText=new WeakReference<>(authorTextView);
    }
    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try{
            // Convert the response into a JSON object.
            JSONObject jsonObject= new JSONObject(s);
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
                mTitleText.get().setText(title);
                mAuthorText.get().setText(authors);
            }else{
                // If none are found, update the UI to
                // show failed results.
                mTitleText.get().setText(R.string.no_results);
                mAuthorText.get().setText("");
            }
        }catch (JSONException e){
            // If onPostExecute does not receive a proper JSON string,
            // update the UI to show failed results.
            mTitleText.get().setText(R.string.no_results);
            mAuthorText.get().setText("");
            e.printStackTrace();
        }
    }
}
