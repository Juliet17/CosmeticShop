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

public class ParfumeActivity extends AppCompatActivity {

    private ListView listViewParfume;

    private ArrayList<Parfume> parfumes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parfume);
        ActionBar actionBar = getSupportActionBar(); // deleting AB
        if (actionBar != null) {
            actionBar.hide();
        }

        parfumes = new ArrayList<>();
        // adding data in array
        parfumes.add(new Parfume(getString(R.string.women_parfume_title), getString(R.string.women_parfume_info), R.drawable.escada));
        parfumes.add(new Parfume(getString(R.string.men_parfume_title), getString(R.string.men_parfume_info), R.drawable.banderas));

        listViewParfume = findViewById(R.id.listViewParfume);

        // connecting adapter
        ArrayAdapter<Parfume> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, parfumes);
        listViewParfume.setAdapter(adapter);

        // adding Listener
        listViewParfume.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Parfume parfume = parfumes.get(position);  // new object of the class Parfume
                Intent intent = new Intent(getApplicationContext(), ParfumeDescriptionActivity.class);
                intent.putExtra("title", parfume.getTitle());
                intent.putExtra("info", parfume.getInfo());
                intent.putExtra("imageId", parfume.getImageId());
                startActivity(intent);
            }
        });
    }
}