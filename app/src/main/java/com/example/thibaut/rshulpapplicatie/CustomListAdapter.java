package com.example.thibaut.rshulpapplicatie;

import android.app.Activity;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thibaut.rshulpapplicatie.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Thibaut on 22/11/2017.
 */

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> itemname;
    private final ArrayList<String> members;
    private final ArrayList<String> image;
    private final ArrayList<String> price;
    private final ArrayList<String> currentLose;
    ImageView imageView;
    TextView txtChange;
    TextView txtPrice;
    TextView txtMember;
    TextView txtTitle;

    public CustomListAdapter(Activity context,ArrayList<String> itemname,ArrayList<String> members,ArrayList<String> image,ArrayList<String> price, ArrayList<String> currentLose) {
        super(context, R.layout.itemlist,itemname);
        this.context= context;
        this.itemname = itemname;
        this.members = members;
        this.image = image;
        this.price = price;
        this.currentLose = currentLose;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.itemlist,null,true);

        txtTitle = (TextView)rowView.findViewById(R.id.item);
        txtMember = (TextView)rowView.findViewById(R.id.ItemMember);
        txtPrice = (TextView)rowView.findViewById(R.id.ItemPrice);
        txtChange = (TextView)rowView.findViewById(R.id.ItemChange);
        imageView = (ImageView)rowView.findViewById(R.id.icon);
        txtTitle.append(itemname.get(position));
        if (members.get(position).equals("true")) {
          txtMember.append(context.getString(R.string.member_true));
        }else {
            if (members.get(position).equals("false")) {
                txtMember.append(context.getString(R.string.member_false));
            }
        }
        txtPrice.append(price.get(position));
        txtChange.append(currentLose.get(position));
        loadImageFromUrl(image.get(position));

        return rowView;
    }

    private void loadImageFromUrl(String s) {
        Picasso.with(context).load(s).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView,new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
