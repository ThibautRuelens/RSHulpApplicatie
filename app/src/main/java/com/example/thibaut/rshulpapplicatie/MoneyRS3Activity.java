package com.example.thibaut.rshulpapplicatie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Spinner;

/**
 * Created by Thibaut on 30/11/2017.
 */
//Klasse die alle activities in money guides van RS3 managed
public class MoneyRS3Activity extends AppCompatActivity implements FragmentInterface {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_rs3);
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

    @Override
    public void spinnerClicked(Spinner spinner,Integer position) {
        String spin = spinner.getItemAtPosition(position).toString();
        SecondFragment fragment = (SecondFragment)getSupportFragmentManager().findFragmentById(R.id.second_fragment);
        fragment.updateData(spin,"RS3");
    }
}
