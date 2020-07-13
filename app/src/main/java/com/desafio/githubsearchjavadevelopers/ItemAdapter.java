package com.desafio.githubsearchjavadevelopers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio.githubsearchjavadevelopers.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(Context getApplicationContext, List<Item> itemArrayList) {
        this.context = getApplicationContext;
        this.items = itemArrayList;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        viewHolder.title.setText(items.get(i).getLogin());
        viewHolder.githubLink.setText(items.get(i).getHtmlUrl());


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
