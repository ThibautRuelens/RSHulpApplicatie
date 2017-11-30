package com.example.thibaut.rshulpapplicatie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private TextView Header;

    private TextView Requirments1;
    private TextView MoneyNeeded1;
    private TextView MoneyAfterSale1;
    private TextView Profit1;

    private TextView Requirments2;
    private TextView MoneyNeeded2;
    private TextView MoneyAfterSale2;
    private TextView Profit2;

    private TextView Requirments3;
    private TextView MoneyNeeded3;
    private TextView MoneyAfterSale3;
    private TextView Profit3;

    private TextView Requirments4;
    private TextView MoneyNeeded4;
    private TextView MoneyAfterSale4;
    private TextView Profit4;

    private TextView Requirments5;
    private TextView MoneyNeeded5;
    private TextView MoneyAfterSale5;
    private TextView Profit5;

    JSONObject HerbloreJson = new JSONObject();

    JSONObject json = new JSONObject();
    JSONObject CookingJson = new JSONObject();
    JSONObject CraftingJson = new JSONObject();
    JSONObject SmithingJson = new JSONObject();



    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);

       Header = (TextView) v.findViewById(R.id.Header);

       Requirments1 = (TextView)v.findViewById(R.id.Requirments1);
       MoneyNeeded1 = (TextView)v.findViewById(R.id.MoneyNeeded1);
       MoneyAfterSale1 = (TextView)v.findViewById(R.id.MoneyAfterSale1);
       Profit1 = (TextView)v.findViewById(R.id.Profit1);

       Requirments2 = (TextView)v.findViewById(R.id.Requirments2);
       MoneyNeeded2 = (TextView)v.findViewById(R.id.MoneyNeeded2);
       MoneyAfterSale2 = (TextView)v.findViewById(R.id.MoneyAfterSale2);
       Profit2 = (TextView)v.findViewById(R.id.Profit2);

       Requirments3 = (TextView)v.findViewById(R.id.Requirments3);
       MoneyNeeded3 = (TextView)v.findViewById(R.id.MoneyNeeded3);
       MoneyAfterSale3 = (TextView)v.findViewById(R.id.MoneyAfterSale3);
       Profit3 = (TextView)v.findViewById(R.id.Profit3);

       Requirments4 = (TextView)v.findViewById(R.id.Requirments4);
       MoneyNeeded4 = (TextView)v.findViewById(R.id.MoneyNeeded4);
       MoneyAfterSale4 = (TextView)v.findViewById(R.id.MoneyAfterSale4);
       Profit4 = (TextView)v.findViewById(R.id.Profit4);

       Requirments5 = (TextView)v.findViewById(R.id.Requirments5);
       MoneyNeeded5 = (TextView)v.findViewById(R.id.MoneyNeeded5);
       MoneyAfterSale5 = (TextView)v.findViewById(R.id.MoneyAfterSale5);
       Profit5 = (TextView)v.findViewById(R.id.Profit5);

        try {
            HerbloreJson.put("Name","test");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            json.put("Herblore",HerbloreJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return v;
    }
    public void updateData(String spinner) {
        Header.setText(R.string.action_choosen_skill);
        Header.append(" "+spinner);
        if (spinner.equals("Cooking")) {
        Requirments1.setText("Cooking");
        }
        if (spinner.equals("Crafting")) {
            Requirments1.setText("Craftring");
        }

        if (spinner.equals("Herblore")) {
            Requirments1.setText("Herblore");
        }
        if (spinner.equals("Smithing")) {
            Requirments1.setText("Smithing");
        }
    }
}
