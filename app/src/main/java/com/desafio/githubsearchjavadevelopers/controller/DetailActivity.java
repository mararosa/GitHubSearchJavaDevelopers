package com.desafio.githubsearchjavadevelopers.controller;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.desafio.githubsearchjavadevelopers.R;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    TextView userLink, username;
    ImageView imageView;
    Toolbar mActionBarToolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }

        imageView = findViewById(R.id.detail_user_image_header);
        username = findViewById(R.id.detail_username_tv);
        userLink = findViewById(R.id.detail_link_tv);

        String username = getIntent().getExtras().getString("login");
        String avatarUrl = getIntent().getExtras().getString("avatar_url");
        String link = getIntent().getExtras().getString("html_url");


    }
}
