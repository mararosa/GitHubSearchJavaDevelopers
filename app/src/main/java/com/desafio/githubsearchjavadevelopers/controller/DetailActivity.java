package com.desafio.githubsearchjavadevelopers.controller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import com.bumptech.glide.Glide;
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

        String userLogin = getIntent().getExtras().getString("login");
        String avatarUrl = getIntent().getExtras().getString("avatar_url");
        String link = getIntent().getExtras().getString("html_url");

        userLink.setText(link);
        Linkify.addLinks(userLink, Linkify.WEB_URLS);

        username.setText(userLogin);
        Glide.with(this)
                .load(avatarUrl)
                .into(imageView);

        getSupportActionBar().setTitle("Details Activity");
    }

    private Intent createShareForcastIntent() {
        String userLogin = getIntent().getExtras().getString("login");
        String link = getIntent().getExtras().getString("link");
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this awasome developer @" + userLogin + ", " + link)
                .getIntent();
        return shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_action_share);
        menuItem.setIntent(createShareForcastIntent());
        return true;
    }
}
