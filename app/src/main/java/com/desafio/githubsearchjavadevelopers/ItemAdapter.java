package com.desafio.githubsearchjavadevelopers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio.githubsearchjavadevelopers.controller.DetailActivity;
import com.desafio.githubsearchjavadevelopers.model.Item;
import com.squareup.picasso.Picasso;

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
        holder.title.setText(items.get(position).getLogin());
        holder.gitHubLink.setText(items.get(position).getHtmlUrl());

        Picasso.with(context)
                .load(items.get(position).getAvatarUrl())
                .placeholder(R.drawable.catload)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, gitHubLink;
        private ImageView imageView;

        public ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.row_username_tv);
            gitHubLink = view.findViewById(R.id.row_githubLink_title_tv);
            imageView = view.findViewById(R.id.row_cover_imageView);

            //on item click
            itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        Item clickedDataItem = items.get(position);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("login", items.get(position).getLogin());
                        intent.putExtra("html_url", items.get(position).getHtmlUrl());
                        intent.putExtra("avatar_url", items.get(position).getAvatarUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getLogin(), Toast.LENGTH_SHORT).show();
                    }
                }
            }));
        }
    }
}
