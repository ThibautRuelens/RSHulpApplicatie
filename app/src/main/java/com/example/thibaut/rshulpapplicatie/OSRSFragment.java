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

public class OSRSFragment extends Fragment {
    private static final String TAG = "OSRS";
    private Button Highscore;
    private Button GE;
    private Button Money;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_osrs, container,false);

        Highscore = (Button) view.findViewById(R.id.HighscoreOSRS);
        Highscore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent selectHighscoreOSRS = new Intent(getActivity(),HighscoreOSRSActivity.class);
                selectHighscoreOSRS.putExtra("Title","OSRS Highscore");
                startActivity(selectHighscoreOSRS);
            }
        });
        GE = (Button) view.findViewById(R.id.GEOSRS);
        GE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent selectGEOSRS = new Intent(getActivity(),GEOSRSActivity.class);
                selectGEOSRS.putExtra("Title","OSRS Grand Exchange");
                startActivity(selectGEOSRS);
            }
        });
        Money = (Button) view.findViewById(R.id.MoneyOSRS);
        Money.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent selectMoneyOSRS = new Intent(getActivity(),HighscoreRS3Activity.class);
                selectMoneyOSRS.putExtra("Title","OSRS Money methodes");
                startActivity(selectMoneyOSRS);
            }
        });
        return view;
    }
}
