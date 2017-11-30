package com.example.thibaut.rshulpapplicatie;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thibaut.rshulpapplicatie.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends Activity
{
    EditText editTextUserName,editTextPassword,editTextConfirmPassword;
    Button btnCreateAccount;

    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

// get Instance of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

// Get Refferences of Views
        editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
// TODO Auto-generated method stub

                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();
                String confirmPassword=editTextConfirmPassword.getText().toString();

// check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), R.string.error_field_required, Toast.LENGTH_LONG).show();
                    return;
                }
// check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), R.string.error_password_not_match, Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    ApiLogin log = new ApiLogin("PUT",password,userName);
                    String url = "http://api.thibautruelens.tk/login.php";
                    Log.i("INFO", url);
                    log.setListener(new ApiLogin.Listener(){

                                        @Override
                                        public void onResult(String result) {
                                            TextView view = (TextView) findViewById(R.id.textView);
                                            try {
                                                //view.setText(result);
                                                JSONObject jObject = new JSONObject(result);
                                                boolean oneObjectsEmail = jObject.getBoolean("success");
                                                String oneObjectsreturn = jObject.getString("return");
                                                String oneObjectsuser = jObject.getString("user");
                                                if(oneObjectsEmail == false) {
                                                    view.setText(R.string.error_user_exists);
                                                    view.setBackground(new ColorDrawable(Color.RED));
                                                }else {
                                                    String oneObjectspass = jObject.getString("pass");
                                                    loginDataBaseAdapter.insertEntry(oneObjectsuser, oneObjectspass);
                                                    Toast.makeText(getApplicationContext(), R.string.action_user_created, Toast.LENGTH_LONG).show();
                                                    Intent HomeGameScreen = new Intent(RegisterActivity.this,MenuActivity.class);
                                                    HomeGameScreen.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                                    startActivity(HomeGameScreen);
                                                    finish();
                                                }


                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }

                                        }});
                            log.execute(url);
// Save the Data in Database
                    //loginDataBaseAdapter.insertEntry(userName, password);
                    //Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    //Intent HomeGameScreen = new Intent(RegisterActivity.this,MenuActivity.class);
                    //startActivity(HomeGameScreen);
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
// TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}