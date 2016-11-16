package com.example.me.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> arr = getTestList();
        MyListAdapter adapter = new MyListAdapter(arr, (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE));

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private ArrayList<Item> getTestList() {
        ArrayList<Item> arr = new ArrayList<Item>();

        for (int i=0; i<10000; i++) {
            arr.add(new Item("Title " + i, i + " items description text looks like this ....", getIconId(i%7)));
        }

        return arr;
    }

    private int getIconId(int i) {
        switch (i) {
            case 1:
                return R.drawable.access_point;
            case 2:
                return R.drawable.account_box;
            case 3:
                return R.drawable.alarm;
            case 4:
                return R.drawable.alarm_plus;
            case 5:
                return R.drawable.apple;
            case 6:
                return R.drawable.android;

        }
        return R.drawable.basket_unfill;
    }
}
