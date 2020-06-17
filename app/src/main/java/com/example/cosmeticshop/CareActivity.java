package com.example.cosmeticshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CareActivity extends AppCompatActivity {

    private ListView listViewCare;
    private ArrayList<Care> cares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        cares = new ArrayList<>();
        // adding data in array
        cares.add(new Care(getString(R.string.facecream_title), getString(R.string.facecream_info), R.drawable.facecream));
        cares.add(new Care(getString(R.string.bodycream_title), getString(R.string.bodycream_info), R.drawable.bodycream));

        listViewCare = findViewById(R.id.listViewCare);

        // connecting adapter
        ArrayAdapter<Care> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, cares);
        listViewCare.setAdapter(adapter);

        // adding Listener
        listViewCare.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Care care = cares.get(position); // new obj of class Care
                Intent intent = new Intent(getApplicationContext(), CareDescriptionActivity.class);
                intent.putExtra("title", care.getTitle());
                intent.putExtra("info", care.getInfo());
                intent.putExtra("imageId", care.getImageId());
                startActivity(intent);
            }
        });
    }
}