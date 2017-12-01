package com.example.thibaut.rshulpapplicatie;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HighscoreRS3Activity extends AppCompatActivity {
    public EditText usernameText;
    ProgressBar pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore_rs3);
        Bundle extras = getIntent().getExtras();
        String extra = extras.getString("Title");
        pr = (ProgressBar)findViewById(R.id.progressBar);
        pr.setVisibility(View.GONE);
        setTitle(extra);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void getHighscore(View view) throws ExecutionException, InterruptedException {
        Api api = new Api(pr);
        final Context context = this;
        usernameText = (EditText) findViewById(R.id.usernameText);
        InputMethodManager imm = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(usernameText.getWindowToken(), 0);
        String username = usernameText.getText().toString();
        username = username.replaceAll(" ", "+");
        String url = "http://services.runescape.com/m=hiscore/index_lite.ws?player=" + username;
        Log.i("INFO", url);
        api.setListener(new Api.Listener(){

            @Override
            public void onTaskResult(String string) {
        List<String> levels = Arrays.asList(string.split("\n"));
        List<String> defenition = Arrays.asList("Skill", "Rank", "Level", "XP");
        List<String> Skills = Arrays.asList("Header","Overall", "Attack", "Defence", "Strength", "Hitpoints", "Ranged", "Prayer", "Magic","Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblore","Agility", "Thieving", "Slayer", "Farming", "Runecraft", "Hunter", "Construction", "Summoning", "Dungeoneering", "Divination", "Inventions");
        LinearLayout responseview = (LinearLayout)findViewById(R.id.responseView);
        responseview.removeAllViews();
        for (int i = 0; i < Skills.size(); i++) {
            LinearLayout newLayout = new LinearLayout(context);
            newLayout.setOrientation(LinearLayout.HORIZONTAL);
            newLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            newLayout.setWeightSum(4);
            for (int j = 0; j < defenition.size(); j++) {
                TextView newText = new TextView(context);
                newText.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT, 1f));
                if (i == 0) {
                    newText.setText(defenition.get(j));
                    newLayout.addView(newText);
                } else {
                    if (j == 0) {
                        newText.setText(Skills.get(i));
                        newLayout.addView(newText);
                    } else {
                        List<String> skill = Arrays.asList(levels.get(i - 1).split(","));
                        Log.d("list", skill.get(j - 1));
                        if (j == 1 && skill.get(j - 1).equals("-1")) {
                            newText.setText("No rank");
                            newLayout.addView(newText);
                        } else {
                            if (j == 3 && skill.get(j - 1).equals("-1")) {
                                newText.setText("0");
                                newLayout.addView(newText);
                            } else {
                                String str = skill.get(j - 1);

                                char[] chars = new char[str.length() + (str.length() / 3)];

                                int offset = str.length() % 3;
                                int idx = 0, strIdx = 0;

                                for (; strIdx < str.length(); idx++, strIdx++)
                                {
                                    if (((strIdx % 3) == offset) && (strIdx != 0))
                                        chars[idx++] = '.';
                                    chars[idx] = str.charAt(strIdx);
                                }

                                String str2 = new String(chars);
                                newText.setText(str2.toString());
                                newLayout.addView(newText);
                            }
                        }
                    }

                }
            }
            responseview.addView(newLayout);
        }
    }


});
        api.execute(url);
    }
}