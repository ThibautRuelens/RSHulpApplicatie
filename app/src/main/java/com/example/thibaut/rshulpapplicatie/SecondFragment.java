package com.example.thibaut.rshulpapplicatie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private TextView Header;

    private TextView Name1;
    private TextView Requirments1;
    private TextView MoneyNeeded1;
    private TextView MoneyAfterSale1;
    private TextView Profit1;

    private TextView Name2;
    private TextView Requirments2;
    private TextView MoneyNeeded2;
    private TextView MoneyAfterSale2;
    private TextView Profit2;

    private TextView Name3;
    private TextView Requirments3;
    private TextView MoneyNeeded3;
    private TextView MoneyAfterSale3;
    private TextView Profit3;

    private TextView Name4;
    private TextView Requirments4;
    private TextView MoneyNeeded4;
    private TextView MoneyAfterSale4;
    private TextView Profit4;

    private TextView Name5;
    private TextView Requirments5;
    private TextView MoneyNeeded5;
    private TextView MoneyAfterSale5;
    private TextView Profit5;

    List<String> item;
    List<List> herblore;
    List<List> cooking;
    List<List> crafting;
    List<List> smithing;
    List<List> herbloreRS3;
    List<List> cookingRS3;
    List<List> craftingRS3;
    List<List> smithingRS3;
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);

       Header = (TextView) v.findViewById(R.id.Header);

       Name1 = (TextView)v.findViewById(R.id.Name1);
       Requirments1 = (TextView)v.findViewById(R.id.Requirments1);
       MoneyNeeded1 = (TextView)v.findViewById(R.id.MoneyNeeded1);
       MoneyAfterSale1 = (TextView)v.findViewById(R.id.MoneyAfterSale1);
       Profit1 = (TextView)v.findViewById(R.id.Profit1);

       Name2 = (TextView)v.findViewById(R.id.Name2);
       Requirments2 = (TextView)v.findViewById(R.id.Requirments2);
       MoneyNeeded2 = (TextView)v.findViewById(R.id.MoneyNeeded2);
       MoneyAfterSale2 = (TextView)v.findViewById(R.id.MoneyAfterSale2);
       Profit2 = (TextView)v.findViewById(R.id.Profit2);

       Name3 = (TextView)v.findViewById(R.id.Name3);
       Requirments3 = (TextView)v.findViewById(R.id.Requirments3);
       MoneyNeeded3 = (TextView)v.findViewById(R.id.MoneyNeeded3);
       MoneyAfterSale3 = (TextView)v.findViewById(R.id.MoneyAfterSale3);
       Profit3 = (TextView)v.findViewById(R.id.Profit3);

       Name4 = (TextView)v.findViewById(R.id.Name4);
       Requirments4 = (TextView)v.findViewById(R.id.Requirments4);
       MoneyNeeded4 = (TextView)v.findViewById(R.id.MoneyNeeded4);
       MoneyAfterSale4 = (TextView)v.findViewById(R.id.MoneyAfterSale4);
       Profit4 = (TextView)v.findViewById(R.id.Profit4);

       Name5 = (TextView)v.findViewById(R.id.Name5);
       Requirments5 = (TextView)v.findViewById(R.id.Requirments5);
       MoneyNeeded5 = (TextView)v.findViewById(R.id.MoneyNeeded5);
       MoneyAfterSale5 = (TextView)v.findViewById(R.id.MoneyAfterSale5);
       Profit5 = (TextView)v.findViewById(R.id.Profit5);

       initHerbOSRS();
       initCookingOSRS();
       initCraftingOSRS();
       initSmithingOSRS();
       initHerbRS3();
       initCookingRS3();
       initCraftingRS3();
       initSmithingRS3();

        return v;
    }
    public void refreshView() {
        Name1.setText(R.string.action_money_name);
        Requirments1.setText(R.string.action_money_Requirement);
        MoneyNeeded1.setText(R.string.action_money_price);
        MoneyAfterSale1.setText(R.string.action_money_sell);
        Profit1.setText(R.string.action_money_profit);

        Name2.setText(R.string.action_money_name);
        Requirments2.setText(R.string.action_money_Requirement);
        MoneyNeeded2.setText(R.string.action_money_price);
        MoneyAfterSale2.setText(R.string.action_money_sell);
        Profit2.setText(R.string.action_money_profit);

        Name3.setText(R.string.action_money_name);
        Requirments3.setText(R.string.action_money_Requirement);
        MoneyNeeded3.setText(R.string.action_money_price);
        MoneyAfterSale3.setText(R.string.action_money_sell);
        Profit3.setText(R.string.action_money_profit);

        Name4.setText(R.string.action_money_name);
        Requirments4.setText(R.string.action_money_Requirement);
        MoneyNeeded4.setText(R.string.action_money_price);
        MoneyAfterSale4.setText(R.string.action_money_sell);
        Profit4.setText(R.string.action_money_profit);

        Name5.setText(R.string.action_money_name);
        Requirments5.setText(R.string.action_money_Requirement);
        MoneyNeeded5.setText(R.string.action_money_price);
        MoneyAfterSale5.setText(R.string.action_money_sell);
        Profit5.setText(R.string.action_money_profit);
    }
    public void initHerbRS3() {
        herbloreRS3 = new ArrayList<>();
        item = new ArrayList<>();
        item.add("level 82");
        item.add("Making weapon poison++");
        item.add("7884");
        item.add("20127");
        item.add("12243");
        herbloreRS3.add(item);
        item = new ArrayList<>();
        item.add("level 59");
        item.add("Cleaning grimy snapdragon");
        item.add("2513");
        item.add("2791");
        item.add("278");
        herbloreRS3.add(item);
        item = new ArrayList<>();
        item.add("level 75");
        item.add("Cleaning grimy torstol");
        item.add("3946");
        item.add("4092");
        item.add("146");
        herbloreRS3.add(item);
        item = new ArrayList<>();
        item.add("level 40");
        item.add("Cleaning grimy irits");
        item.add("3241");
        item.add("3421");
        item.add("180");
        herbloreRS3.add(item);
        item = new ArrayList<>();
        item.add("level 48");
        item.add("Cleaning grimy avantoe");
        item.add("1626");
        item.add("1804");
        item.add("178");
        herbloreRS3.add(item);
    }
    public void initCookingRS3() {
        cookingRS3 = new ArrayList<>();
        item = new ArrayList<>();
        item.add("level 85");
        item.add("Making raw wild pies");
        item.add("2145");
        item.add("5440");
        item.add("3295");
        cookingRS3.add(item);
        item = new ArrayList<>();
        item.add("level 95");
        item.add("Making raw summer pie");
        item.add("5833");
        item.add("9128");
        item.add("3295");
        cookingRS3.add(item);
        item = new ArrayList<>();
        item.add("level 70");
        item.add("Making raw admiral pie");
        item.add("2027");
        item.add("4318");
        item.add("2291");
        cookingRS3.add(item);
        item = new ArrayList<>();
        item.add("level 68");
        item.add("Making tuna potatoes");
        item.add("1108");
        item.add("1743");
        item.add("635");
        cookingRS3.add(item);
        item = new ArrayList<>();
        item.add("level 10");
        item.add("Making pastry dough");
        item.add("287");
        item.add("508");
        item.add("221");
        cookingRS3.add(item);
    }
    public void initCraftingRS3() {
        craftingRS3 = new ArrayList<>();
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning royal dragonhide");
        item.add("4447");
        item.add("4748");
        item.add("301");
        craftingRS3.add(item);
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning black dragonhide");
        item.add("3512");
        item.add("3654");
        item.add("142");
        craftingRS3.add(item);
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning blue dragonhide");
        item.add("2556");
        item.add("2642");
        item.add("86");
        craftingRS3.add(item);
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning green dragonhide");
        item.add("1913");
        item.add("1988");
        item.add("75");
        craftingRS3.add(item);
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning red dragonhide");
        item.add("2886");
        item.add("2957");
        item.add("71");
        craftingRS3.add(item);
    }
    public void initSmithingRS3() {
        smithingRS3 = new ArrayList<>();
        item = new ArrayList<>();
        item.add("level 99");
        item.add("Smithing rune 2h swords using a portable forge");
        item.add("41652");
        item.add("42448");
        item.add("796");
        smithingRS3.add(item);
        item = new ArrayList<>();
        item.add("level 35");
        item.add("Smithing cannonballs");
        item.add("154");
        item.add("301");
        item.add("147");
        smithingRS3.add(item);
        item = new ArrayList<>();
        item.add("level 40");
        item.add("Smithing gold ore");
        item.add("188");
        item.add("355");
        item.add("167");
        smithingRS3.add(item);
        item = new ArrayList<>();
        item.add("level 85");
        item.add("Making runite bars using a portable forge");
        item.add("11482");
        item.add("13884");
        item.add("2402");
        smithingRS3.add(item);
        item = new ArrayList<>();
        item.add("level 85");
        item.add("Smithing runite bars at Blast Furnace");
        item.add("11526");
        item.add("13884");
        item.add("2358");
        smithingRS3.add(item);}
    public void initHerbOSRS() {
        herblore = new ArrayList<>();
        item = new ArrayList<>();
        item.add("level 75");
        item.add("Cleaning grimy torstol");
        item.add("7856");
        item.add("7986");
        item.add("130");
        herblore.add(item);
        item = new ArrayList<>();
        item.add("level 50");
        item.add("Making avantoe potions");
        item.add("2103 + 5");
        item.add("2319");
        item.add("211");
        herblore.add(item);
        item = new ArrayList<>();
        item.add("level 69");
        item.add("Making lantadyme potions");
        item.add("1756 + 5");
        item.add("1928");
        item.add("167");
        herblore.add(item);
        item = new ArrayList<>();
        item.add("level 66");
        item.add("Making cadantine potions");
        item.add("1915 + 5");
        item.add("2074");
        item.add("154");
        herblore.add(item);
        item = new ArrayList<>();
        item.add("level 30");
        item.add("Making ranarr potions");
        item.add("6485 + 5");
        item.add("6642");
        item.add("152");
        herblore.add(item);
    }
    public void initCookingOSRS() {
        cooking = new ArrayList<>();
        item = new ArrayList<>();
        item.add("level 85");
        item.add("Making raw wild pies");
        item.add("3119");
        item.add("3754");
        item.add("635");
        cooking.add(item);
        item = new ArrayList<>();
        item.add("level 95");
        item.add("Making raw summer pie");
        item.add("547");
        item.add("1129");
        item.add("582");
        cooking.add(item);
        item = new ArrayList<>();
        item.add("level 90");
        item.add("Cooking raw dark crabs");
        item.add("978");
        item.add("1223");
        item.add("245");
        cooking.add(item);
        item = new ArrayList<>();
        item.add("level 80");
        item.add("Cooking raw sharks");
        item.add("608");
        item.add("779");
        item.add("171");
        cooking.add(item);
        item = new ArrayList<>();
        item.add("level 30");
        item.add("Cooking raw karambwan");
        item.add("607");
        item.add("755");
        item.add("148");
        cooking.add(item);
    }
    public void initCraftingOSRS() {
        crafting = new ArrayList<>();
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning blue dragonhide");
        item.add("1954");
        item.add("2121");
        item.add("167");
        crafting.add(item);
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning black dragonhide");
        item.add("3172");
        item.add("3339");
        item.add("167");
        crafting.add(item);
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning green dragonhide");
        item.add("2812");
        item.add("2870");
        item.add("68");
        crafting.add(item);
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning green dragonhide");
        item.add("1552");
        item.add("1701");
        item.add("149");
        crafting.add(item);
        item = new ArrayList<>();
        item.add("no level");
        item.add("Tanning cowhide");
        item.add("74");
        item.add("97");
        item.add("23");
        crafting.add(item);
    }
    public void initSmithingOSRS() {
        smithing = new ArrayList<>();
        item = new ArrayList<>();
        item.add("level 85");
        item.add("Smithing runite bars at Blast Furnace");
        item.add("12063");
        item.add("12513");
        item.add("450");
        smithing.add(item);
        item = new ArrayList<>();
        item.add("level 70");
        item.add("Smithing adamantite bars at Blast Furnace");
        item.add("1798");
        item.add("2041");
        item.add("243");
        smithing.add(item);
        item = new ArrayList<>();
        item.add("level 30");
        item.add("Smithing steel bars at Blast Furnace");
        item.add("274");
        item.add("392");
        item.add("118");
        smithing.add(item);
        item = new ArrayList<>();
        item.add("level 50");
        item.add("Smithing mithril bars at Blast Furnace");
        item.add("545");
        item.add("701");
        item.add("156");
        smithing.add(item);
        item = new ArrayList<>();
        item.add("level 89");
        item.add("Smithing rune dart tips");
        item.add("12516");
        item.add("12990");
        item.add("474");
        smithing.add(item);
    }
    public void updateData(String spinner,String type) {
        Header.setText(R.string.action_choosen_skill);
        Header.append(" " + spinner);
        if (type.equals("RS3")) {
            if (spinner.equals("Cooking")) {
                refreshView();
                for (int i = 0; i < cookingRS3.size(); i++) {
                    for (int j = 0; j < cookingRS3.get(i).size(); j++) {
                        if (i == 0) {
                            if (j == 0) {
                                Requirments1.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name1.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded1.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale1.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit1.append(cookingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 1) {
                            if (j == 0) {
                                Requirments2.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name2.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded2.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale2.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit2.append(cookingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 2) {
                            if (j == 0) {
                                Requirments3.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name3.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded3.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale3.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit3.append(cookingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 3) {
                            if (j == 0) {
                                Requirments4.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name4.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded4.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale4.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit4.append(cookingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 4) {
                            if (j == 0) {
                                Requirments5.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name5.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded5.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale5.append(cookingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit5.append(cookingRS3.get(i).get(j).toString());
                            }
                        }
                    }
                }
            }
            if (spinner.equals("Crafting")) {
                refreshView();
                for (int i = 0; i < craftingRS3.size(); i++) {
                    for (int j = 0; j < craftingRS3.get(i).size(); j++) {
                        if (i == 0) {
                            if (j == 0) {
                                Requirments1.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name1.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded1.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale1.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit1.append(craftingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 1) {
                            if (j == 0) {
                                Requirments2.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name2.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded2.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale2.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit2.append(craftingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 2) {
                            if (j == 0) {
                                Requirments3.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name3.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded3.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale3.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit3.append(craftingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 3) {
                            if (j == 0) {
                                Requirments4.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name4.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded4.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale4.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit4.append(craftingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 4) {
                            if (j == 0) {
                                Requirments5.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name5.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded5.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale5.append(craftingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit5.append(craftingRS3.get(i).get(j).toString());
                            }
                        }
                    }
                }
            }

            if (spinner.equals("Herblore")) {
                refreshView();
                for (int i = 0; i < herbloreRS3.size(); i++) {
                    for (int j = 0; j < herbloreRS3.get(i).size(); j++) {
                        if (i == 0) {
                            if (j == 0) {
                                Requirments1.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name1.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded1.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale1.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit1.append(herbloreRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 1) {
                            if (j == 0) {
                                Requirments2.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name2.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded2.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale2.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit2.append(herbloreRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 2) {
                            if (j == 0) {
                                Requirments3.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name3.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded3.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale3.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit3.append(herbloreRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 3) {
                            if (j == 0) {
                                Requirments4.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name4.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded4.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale4.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit4.append(herbloreRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 4) {
                            if (j == 0) {
                                Requirments5.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name5.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded5.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale5.append(herbloreRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit5.append(herbloreRS3.get(i).get(j).toString());
                            }
                        }
                    }
                }
            }
            if (spinner.equals("Smithing")) {
                refreshView();
                for (int i = 0; i < smithingRS3.size(); i++) {
                    for (int j = 0; j < smithingRS3.get(i).size(); j++) {
                        if (i == 0) {
                            if (j == 0) {
                                Requirments1.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name1.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded1.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale1.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit1.append(smithingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 1) {
                            if (j == 0) {
                                Requirments2.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name2.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded2.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale2.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit2.append(smithingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 2) {
                            if (j == 0) {
                                Requirments3.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name3.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded3.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale3.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit3.append(smithingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 3) {
                            if (j == 0) {
                                Requirments4.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name4.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded4.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale4.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit4.append(smithingRS3.get(i).get(j).toString());
                            }
                        }
                        if (i == 4) {
                            if (j == 0) {
                                Requirments5.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 1) {
                                Name5.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 2) {
                                MoneyNeeded5.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 3) {
                                MoneyAfterSale5.append(smithingRS3.get(i).get(j).toString());
                            }
                            if (j == 4) {
                                Profit5.append(smithingRS3.get(i).get(j).toString());
                            }
                        }
                    }
                }
            }
        }
    if(type.equals("OSRS")) {
        if (spinner.equals("Cooking")) {
            refreshView();
            for (int i = 0; i < cooking.size(); i++) {
                for (int j = 0; j < cooking.get(i).size(); j++) {
                    if (i == 0) {
                        if (j == 0) {
                            Requirments1.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name1.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded1.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale1.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit1.append(cooking.get(i).get(j).toString());
                        }
                    }
                    if (i == 1) {
                        if (j == 0) {
                            Requirments2.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name2.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded2.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale2.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit2.append(cooking.get(i).get(j).toString());
                        }
                    }
                    if (i == 2) {
                        if (j == 0) {
                            Requirments3.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name3.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded3.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale3.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit3.append(cooking.get(i).get(j).toString());
                        }
                    }
                    if (i == 3) {
                        if (j == 0) {
                            Requirments4.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name4.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded4.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale4.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit4.append(cooking.get(i).get(j).toString());
                        }
                    }
                    if (i == 4) {
                        if (j == 0) {
                            Requirments5.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name5.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded5.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale5.append(cooking.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit5.append(cooking.get(i).get(j).toString());
                        }
                    }
                }
            }
        }
        if (spinner.equals("Crafting")) {
            refreshView();
            for (int i = 0; i < crafting.size(); i++) {
                for (int j = 0; j < crafting.get(i).size(); j++) {
                    if (i == 0) {
                        if (j == 0) {
                            Requirments1.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name1.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded1.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale1.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit1.append(crafting.get(i).get(j).toString());
                        }
                    }
                    if (i == 1) {
                        if (j == 0) {
                            Requirments2.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name2.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded2.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale2.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit2.append(crafting.get(i).get(j).toString());
                        }
                    }
                    if (i == 2) {
                        if (j == 0) {
                            Requirments3.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name3.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded3.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale3.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit3.append(crafting.get(i).get(j).toString());
                        }
                    }
                    if (i == 3) {
                        if (j == 0) {
                            Requirments4.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name4.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded4.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale4.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit4.append(crafting.get(i).get(j).toString());
                        }
                    }
                    if (i == 4) {
                        if (j == 0) {
                            Requirments5.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name5.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded5.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale5.append(crafting.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit5.append(crafting.get(i).get(j).toString());
                        }
                    }
                }
            }
        }

        if (spinner.equals("Herblore")) {
            refreshView();
            for (int i = 0; i < herblore.size(); i++) {
                for (int j = 0; j < herblore.get(i).size(); j++) {
                    if (i == 0) {
                        if (j == 0) {
                            Requirments1.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name1.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded1.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale1.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit1.append(herblore.get(i).get(j).toString());
                        }
                    }
                    if (i == 1) {
                        if (j == 0) {
                            Requirments2.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name2.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded2.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale2.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit2.append(herblore.get(i).get(j).toString());
                        }
                    }
                    if (i == 2) {
                        if (j == 0) {
                            Requirments3.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name3.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded3.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale3.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit3.append(herblore.get(i).get(j).toString());
                        }
                    }
                    if (i == 3) {
                        if (j == 0) {
                            Requirments4.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name4.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded4.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale4.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit4.append(herblore.get(i).get(j).toString());
                        }
                    }
                    if (i == 4) {
                        if (j == 0) {
                            Requirments5.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name5.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded5.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale5.append(herblore.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit5.append(herblore.get(i).get(j).toString());
                        }
                    }
                }
            }
        }
        if (spinner.equals("Smithing")) {
            refreshView();
            for (int i = 0; i < smithing.size(); i++) {
                for (int j = 0; j < smithing.get(i).size(); j++) {
                    if (i == 0) {
                        if (j == 0) {
                            Requirments1.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name1.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded1.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale1.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit1.append(smithing.get(i).get(j).toString());
                        }
                    }
                    if (i == 1) {
                        if (j == 0) {
                            Requirments2.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name2.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded2.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale2.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit2.append(smithing.get(i).get(j).toString());
                        }
                    }
                    if (i == 2) {
                        if (j == 0) {
                            Requirments3.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name3.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded3.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale3.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit3.append(smithing.get(i).get(j).toString());
                        }
                    }
                    if (i == 3) {
                        if (j == 0) {
                            Requirments4.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name4.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded4.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale4.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit4.append(smithing.get(i).get(j).toString());
                        }
                    }
                    if (i == 4) {
                        if (j == 0) {
                            Requirments5.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 1) {
                            Name5.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 2) {
                            MoneyNeeded5.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 3) {
                            MoneyAfterSale5.append(smithing.get(i).get(j).toString());
                        }
                        if (j == 4) {
                            Profit5.append(smithing.get(i).get(j).toString());
                        }
                    }
                }
            }
        }
        }
    }
}
