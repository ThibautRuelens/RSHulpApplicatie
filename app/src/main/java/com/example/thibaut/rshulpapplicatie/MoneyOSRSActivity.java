package com.example.thibaut.rshulpapplicatie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Spinner;

/**
 * Created by Thibaut on 30/11/2017.
 */

public class MoneyOSRSActivity extends AppCompatActivity implements FragmentInterface {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_osrs);
    }

    @Override
    public void spinnerClicked(Spinner spinner,Integer position) {
        String spin = spinner.getItemAtPosition(position).toString();

        Log.i("test",spin);
        SecondFragment fragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.second_fragment);
        fragment.updateData(spin);
    }
}
