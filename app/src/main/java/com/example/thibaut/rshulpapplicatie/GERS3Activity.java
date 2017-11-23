package com.example.thibaut.rshulpapplicatie;


import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GERS3Activity extends AppCompatActivity {
    public EditText itemText;
    public ProgressBar pr ;
    ListView list;
    Activity activity = this;
    ArrayList<String> itemname = new ArrayList<String>();
    ArrayList<String> members = new ArrayList<String>();
    ArrayList<String> image= new ArrayList<String>();
    ArrayList<String> currentpriceArr = new ArrayList<String>();
    ArrayList<String> todaypriceArr = new ArrayList<String>();


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gers3);
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
        String url = "http://api.thibautruelens.tk/items.php?table=rs3item&name=" + item;
        Log.i("INFO", url);
        api.setListener(new Api.Listener(){

            @Override
            public void onTaskResult(String string){
                try {
                    JSONObject jObject = new JSONObject(string);
                    JSONArray jArray = jObject.getJSONArray("data");
                    itemname.clear();
                    members.clear();
                    image.clear();
                    currentpriceArr.clear();
                    todaypriceArr.clear();
                    for (int i=0; i < jArray.length(); i++)
                    {
                        try {
                            JSONObject oneObject = jArray.getJSONObject(i);
                            // Pulling items from the array
                            String oneObjectsImage = oneObject.getString("icon");
                            String oneObjectsName = oneObject.getString("name");
                            String oneObjectsmember = oneObject.getString("members");
                            String current = oneObject.getString("current");
                            String today = oneObject.getString("today");
                            JSONObject currentObject = new JSONObject(current);
                            JSONObject todayObject = new JSONObject(today);
                            Integer currentprice = currentObject.getInt("price");
                            Integer todayprice = todayObject.getInt("price");
                            itemname.add(oneObjectsName);
                            members.add(oneObjectsmember);
                            image.add(oneObjectsImage);
                            currentpriceArr.add(currentprice.toString());
                            todaypriceArr.add(todayprice.toString());
                        } catch (JSONException e) {
                            // Oops
                        }

                        CustomListAdapter adapter;
                        adapter = new CustomListAdapter(activity,itemname,members,image,currentpriceArr,todaypriceArr);
                        list =(ListView)findViewById(R.id.list);
                        list.setAdapter(adapter);
                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                // TODO Auto-generated method stub
                                String Slecteditem= itemname.get(position);
                                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        api.execute(url);
    }

}


