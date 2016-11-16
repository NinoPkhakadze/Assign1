package com.example.me.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Me on 11/14/16.
 */
public class MyListAdapter extends BaseAdapter {

    private ArrayList<Item> arr;
    private LayoutInflater layoutInflater;

    public MyListAdapter(ArrayList<Item> arr, LayoutInflater layoutInflater) {
        this.arr = arr;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        Log.d("ListViewApp", "getItem - " + i);
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("ListViewApp", "getView - " + position + "; convertedView - " + convertView);
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.titleText);
            holder.description = (TextView) convertView.findViewById(R.id.description);
            holder.icon = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(arr.get(position).title);
        holder.description.setText(arr.get(position).description);
        holder.icon.setImageResource(arr.get(position).imgId);


        return convertView;
    }

    public class ViewHolder {
        TextView title, description;
        ImageView icon;
    }
}
