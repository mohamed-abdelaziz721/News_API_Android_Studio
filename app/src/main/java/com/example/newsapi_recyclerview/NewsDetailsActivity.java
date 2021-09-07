package com.example.newsapi_recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {

    String title,description,content,imageUrl,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");
        content = getIntent().getStringExtra("content");
        imageUrl = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");

        TextView titleTV = findViewById(R.id.idTV_title);
        TextView subTitleTV = findViewById(R.id.sub_title);
        TextView contentTV = findViewById(R.id.content);
        ImageView newsIV = findViewById(R.id.idTV_news);
        Button readNewsBtn = findViewById(R.id.readNews_btn);

        titleTV.setText(title);
        subTitleTV.setText(description);
        contentTV.setText(content);
        Picasso.get().load(imageUrl).into(newsIV);
        readNewsBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });


    }
}