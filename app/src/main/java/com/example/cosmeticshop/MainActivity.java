package com.example.cosmeticshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listViewMainItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar(); // deleting AB
        if (actionBar != null) {
            actionBar.hide();
        }

        listViewMainItems = findViewById(R.id.listViewMainItems);
        listViewMainItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {   // events listener
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), MakeUpActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), ParfumeActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), CareActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }
}