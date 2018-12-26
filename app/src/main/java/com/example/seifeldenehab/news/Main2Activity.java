package com.example.seifeldenehab.news;

import android.content.Intent;
import android.media.Image;
import android.service.autofill.Dataset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seifeldenehab.news.Json.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView titleTextView = findViewById(R.id.content_title);
        TextView contentTextView = findViewById(R.id.content_content);
        ImageView imgView=findViewById(R.id.content_img);

Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String img = intent.getStringExtra("img");


        titleTextView.setText(title);
        contentTextView.setText(content);
        Picasso.get().load(img).into(imgView);
    }
}
