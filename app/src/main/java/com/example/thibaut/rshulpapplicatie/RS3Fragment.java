package com.example.thibaut.rshulpapplicatie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Thibaut on 20/11/2017.
 */

public class RS3Fragment extends Fragment {
    private static final String TAG = "RS3";
    private Button Highscore;
    private Button GE;
    private Button Money;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_rs3, container,false);
        Highscore = (Button) view.findViewById(R.id.HighscoreRS3);
        Highscore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent selectHighscoreRS3 = new Intent(getActivity(),HighscoreRS3Activity.class);
                selectHighscoreRS3.putExtra("Title","RS3 Highscore");
                startActivity(selectHighscoreRS3);
            }
        });
        GE = (Button) view.findViewById(R.id.GERS3);
        GE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent selectGERS3 = new Intent(getActivity(),HighscoreRS3Activity.class);
                selectGERS3.putExtra("Title","RS3 Grand Exchange");
                startActivity(selectGERS3);
            }
        });
        Money = (Button) view.findViewById(R.id.MoneyRS3);
        Money.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent selectMoneyS3 = new Intent(getActivity(),HighscoreRS3Activity.class);
                selectMoneyS3.putExtra("Title","RS3 Money Methodes");
                startActivity(selectMoneyS3);
            }
        });
        return view;
    }

}
