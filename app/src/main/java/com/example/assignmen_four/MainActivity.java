package com.example.assignmen_four;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.mainListView);
        String[] options = {"Custom ListView", "Expandable ListView"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    showCustomListView();
                } else {
                    showExpandableListView();
                }
            }
        });
    }

    private void showCustomListView() {
        setContentView(R.layout.activity_list_view);
        ListView customListView = findViewById(R.id.customListView);

        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        customListView.setAdapter(adapter);
    }

    private void showExpandableListView() {
        setContentView(R.layout.activity_expandable_list);
        ExpandableListView expandableListView = findViewById(R.id.expandableListView);

        List<String> parentList = new ArrayList<>();
        HashMap<String, List<String>> childList = new HashMap<>();

        parentList.add("Fruits");
        parentList.add("Vegetables");

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        List<String> vegetables = new ArrayList<>();
        vegetables.add("Carrot");
        vegetables.add("Broccoli");
        vegetables.add("Spinach");

        childList.put(parentList.get(0), fruits);
        childList.put(parentList.get(1), vegetables);

        ExpandableListAdapter adapter = new ExpandableListAdapter(this, parentList, childList);
        expandableListView.setAdapter(adapter);
    }
}
