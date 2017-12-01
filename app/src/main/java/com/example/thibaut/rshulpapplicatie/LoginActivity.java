package com.example.thibaut.rshulpapplicatie;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Thibaut on 1/12/2017.
 */

public class LoginActivity extends AppCompatActivity{

    Button btnSignIn;
    LoginDataBaseAdapter loginDataBaseAdapter;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

// get Instance of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

// get the Refferences of views
        final EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);

        btnSignIn=(Button)findViewById(R.id.buttonSignIn);

// Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
// get The User name and Password
                final String userName=editTextUserName.getText().toString();
                final String password=editTextPassword.getText().toString();
                ApiLogin log = new ApiLogin("POST",password,userName);
                String url = "http://api.thibautruelens.tk/login.php";
                Log.i("INFO", url);
                log.setListener(new ApiLogin.Listener(){

                    @Override
                    public void onResult(String result) {
                        try {
                            //view.setText(result);
                            JSONObject jObject = new JSONObject(result);
                            JSONArray jArray = jObject.getJSONArray("data");
                            JSONObject oneObject = jArray.getJSONObject(0);
                            String pass = oneObject.getString("password");
                            String email = oneObject.getString("email");

                            if(pass.equals(password) && email.equals(userName)) {
                                loginDataBaseAdapter.insertEntry(userName,password);
                                Toast.makeText(LoginActivity.this, R.string.success_login, Toast.LENGTH_LONG).show();
                                Intent HomeGameScreen = new Intent(LoginActivity.this,MenuActivity.class);
                                HomeGameScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(HomeGameScreen);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this, R.string.error_email_or_password, Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }});
                log.execute(url);
            }
        });

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onDestroy() {
// TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
