package com.example.thibaut.rshulpapplicatie;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Thibaut on 15/11/2017.
 */

public class Api extends AsyncTask<String,Void,String> {
    private ProgressBar mProgressBar;

    private Listener listener;

    public interface Listener{
        void onTaskResult(String string);
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }
    public Api(ProgressBar progressBar) {
        super();
        mProgressBar = progressBar;
    }
    @Override
    protected void onPreExecute() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String s) {
        if (listener!=null){ listener.onTaskResult(s); }
        mProgressBar.setVisibility(View.GONE);

    }
    protected String doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            catch (FileNotFoundException e) {
                return "Not found";
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return "false";
        }
    }
}
