package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void,Integer,String> {
    private ProgressBar progressBar;
    private WeakReference<TextView> mTextView;
    SimpleAsyncTask(TextView tv, ProgressBar progressBar1){

        mTextView=new WeakReference<>(tv);
        this.progressBar=progressBar1;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setMax(100);
    }

    @Override
    protected String doInBackground(Void... voids) {

        //Generate a random number between 0 and 10
        Random r =new Random();
        int n=r.nextInt(11);

        //Make the task take long enough that we have
        //time to rotate the phone while it is running
        int s=n*200;

        //sleep for the random amount of time
        try{
            Thread.sleep(s);

            for (int i = 0; i <=n; i++) {
                int progress=(i*100)/n;
                publishProgress(progress);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException exception){
                    exception.printStackTrace();
                }

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        //Return a String result
        return "Awake at last after sleeping for "+s +" milliseconds!";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
        Log.d("asyncTask", "onProgressUpdate: "+values[0]);
    }

    /**
     * when the doInBackground() method completes, the return value is automatically passed
     * to the onPostExecute() callback
     * @param result
     */

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        /**
         * because mTextView is a weak reference, you have to deference it with the
         * get() method to get the underlying TextView object, and to call setText() on it.
         */
        mTextView.get().setText(result);

    }
}
