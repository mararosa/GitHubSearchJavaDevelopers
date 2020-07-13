package com.desafio.githubsearchjavadevelopers.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.desafio.githubsearchjavadevelopers.R;
import com.desafio.githubsearchjavadevelopers.model.Item;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    TextView disconnected;
    private Item item;
    ProgressDialog pd;
    private LinearLayout linearContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
