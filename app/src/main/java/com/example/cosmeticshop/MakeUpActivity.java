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

public class MakeUpActivity extends AppCompatActivity {

    private ListView listViewMakeUp;

    private ArrayList<MakeUp> makeUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up);
        ActionBar actionBar = getSupportActionBar(); // deleting AB
        if (actionBar != null) {
            actionBar.hide();
        }
        makeUp = new ArrayList<>();
        // adding data in array
        makeUp.add(new MakeUp(getString(R.string.lipstick_title), getString(R.string.lipstick_info), R.drawable.chanel));
        makeUp.add(new MakeUp(getString(R.string.eyeshadows_title), getString(R.string.eyeshadows_info), R.drawable.mac));
        makeUp.add(new MakeUp(getString(R.string.powder_title), getString(R.string.powder_info), R.drawable.clinique));
        listViewMakeUp = findViewById(R.id.listViewMakeUp);

        ArrayAdapter<MakeUp> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, makeUp);
        listViewMakeUp.setAdapter(adapter);  // connecting adapter

        // adding Listener
        listViewMakeUp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                MakeUp makeup = makeUp.get(position);
                Intent intent = new Intent(getApplicationContext(), MakeUpDescriptionActivity.class);
                // putting info in intent
                intent.putExtra("title", makeup.getTitle());
                intent.putExtra("info", makeup.getInfo());
                intent.putExtra("imageId", makeup.getImageId());
                startActivity(intent);
            }
        });

    }
}