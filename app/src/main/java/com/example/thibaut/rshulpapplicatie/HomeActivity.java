package com.example.thibaut.rshulpapplicatie;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends Activity
{
    Button btnSignIn,btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

// create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

// Get The Refference Of Buttons
        btnSignIn=(Button)findViewById(R.id.buttonSignIN);
        btnSignUp=(Button)findViewById(R.id.buttonSignUP);

        Boolean known = loginDataBaseAdapter.getCountEntry();
        if(known == true)  {
            Toast.makeText(HomeActivity.this, "Not logged out from last time", Toast.LENGTH_LONG).show();
            Intent HomeGameScreen = new Intent(HomeActivity.this,MenuActivity.class);
            startActivity(HomeGameScreen);

        }

// Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

/// Create Intent for SignUpActivity abd Start The Activity
                Intent intentSignUP=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intentSignUP);
            }
        });
    }
    // Methos to handleClick Event of Sign In Button
    public void signIn(View V)
    {
        final Dialog dialog = new Dialog(HomeActivity.this);
        dialog.setContentView(R.layout.activity_login);
        dialog.setTitle("Login");

// get the Refferences of views
        final EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

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
                                Toast.makeText(HomeActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                                Intent HomeGameScreen = new Intent(HomeActivity.this,MenuActivity.class);
                                startActivity(HomeGameScreen);
                            }
                            else
                            {
                                Toast.makeText(HomeActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }});
                log.execute(url);
            }
        });

        dialog.show();
    }
    public void test(View v) {

        Intent dbmanager = new Intent(this,AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
// Close The Database
        loginDataBaseAdapter.close();
    }
};