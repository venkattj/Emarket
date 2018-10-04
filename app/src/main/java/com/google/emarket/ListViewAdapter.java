package com.google.emarket;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Item> {

    public Activity activity;
    public List<Item> litem;
    public LayoutInflater inflater;

    public ListViewAdapter(Activity activity, List<Item> litem) {
        super(activity,R.layout.list_items,litem);
        this.activity = activity;
        this.litem = litem;
    }

    @Override
    public int getCount() {
        return litem.size();
    }

    @Override
    public Item getItem(int position) {
        return litem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = activity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.list_items,null,true);
        TextView txtitem=(TextView)itemView.findViewById(R.id.list_name);
        TextView txtprice =(TextView)itemView.findViewById(R.id.list_price);
        Item item= litem.get(position);
        txtitem.setText(item.getName());
        txtprice.setText(item.getPrice());
        return itemView;
    }
}
