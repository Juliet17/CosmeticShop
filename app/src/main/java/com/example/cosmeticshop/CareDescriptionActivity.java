package com.example.cosmeticshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CareDescriptionActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewMakeupItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_description);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewMakeupItems = findViewById(R.id.imageViewMakeupItems);

        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("imageId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int imageId = intent.getIntExtra("imageId", -1);

            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewMakeupItems.setImageResource(imageId);
        } else {
            Intent backToCategory = new Intent(this, CareActivity.class);
            startActivity(backToCategory);
        }
    }
}