package com.example.thibaut.rshulpapplicatie;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GEOSRSActivity extends AppCompatActivity {
    public EditText itemText;
    public ProgressBar pr ;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geosrs);
        Bundle extras = getIntent().getExtras();
        String extra = extras.getString("Title");
        setTitle(extra);
        pr = (ProgressBar)findViewById(R.id.progressBar);
        pr.setVisibility(View.GONE);
    }

    public void getItem(View view) throws ExecutionException, InterruptedException {
        Api api = new Api(pr);
        itemText = (EditText) findViewById(R.id.itemText);
        String item = itemText.getText().toString();
        item = item.replaceAll(" ", "%20");
        String url = "http://www.thibautruelens.tk/ApiController/runescapeApi/osrsitem/" + item;
        Log.i("INFO", url);
        api.setListener(new Api.Listener(){

            @Override
            public void onTaskResult(String string){
                try {
                    JSONObject jObject = new JSONObject(string);
                    TextView test = (TextView)findViewById(R.id.textView);
                    JSONArray jArray = jObject.getJSONArray("data");
                    for (int i=0; i < jArray.length(); i++)
                    {
                        try {
                            JSONObject oneObject = jArray.getJSONObject(i);
                            // Pulling items from the array
                            String oneObjectsItem = oneObject.getString("icon");
                            String oneObjectsItem2 = oneObject.getString("name");
                            test.append(oneObjectsItem);
                            test.append(oneObjectsItem2);
                            test.append(" ");
                        } catch (JSONException e) {
                            // Oops
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        api.execute(url);
    }

}


