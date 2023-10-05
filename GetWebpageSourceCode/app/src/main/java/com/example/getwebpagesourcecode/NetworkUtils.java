package com.example.getwebpagesourcecode;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class NetworkUtils {

     static String getSourceCode(String mUrl){

         HttpURLConnection connection = null;
         BufferedReader reader = null;
         try {
             URL url = new URL(mUrl);
             connection = (HttpURLConnection) url.openConnection();
             connection.connect();
             reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             StringBuilder content = new StringBuilder();
             String line;
             while ((line = reader.readLine()) != null) {
                 content.append(line).append("\n");
             }
//             Log.d("SourceCode", content.toString());
             return content.toString();
         } catch (IOException e) {
             e.printStackTrace();
             return null;
         } finally {
             if (connection != null) {
                 connection.disconnect();
             }
             if (reader != null) {
                 try {
                     reader.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }


    }
}
