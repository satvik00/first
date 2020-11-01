package com.example.userinterface;
/*
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class feedAdapter extends RecyclerView.Adapter<feedholder>  {
    private ArrayList<news> feed;
    private feedItemClicked f;

    public feedAdapter(ArrayList<news> q,feedItemClicked fee){
        f=fee;
        feed=q;
    }
    @NonNull
    @Override
    public feedholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item,parent,false);
        final feedholder g=new feedholder(view);
        view.setOnClickListener(view1 -> f.onItemClicked(feed.get(g.getAdapterPosition())));
        return g;
    }

    @Override
    public void onBindViewHolder(@NonNull feedholder holder, int position) {
        news currentview= feed.get(position);
        holder.textView.setText(currentview.getTitle());
        holder.authorView.setText(currentview.getAuthor());
        String imgurl=currentview.getUrlToImage();
        Picasso.get().load(imgurl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return feed.size();
    }
    public void updatedNews(ArrayList<news> updates){
        feed.clear();
        feed.addAll(updates);
        notifyDataSetChanged();
    }
}*/

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class feedAdapter extends RecyclerView.Adapter<feedholder> {
    Context context;
    List<Articles> articles;
    public feedAdapter( List<Articles> articles,Context context) {
        this.context = context;
        this.articles = articles;
    }


    @NonNull
    @Override
    public feedholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_feed,parent,false);
        final feedholder g=new feedholder(view);
        return g;
    }

    @Override
    public void onBindViewHolder(@NonNull feedholder holder, int position) {
        final Articles a=articles.get(position);
        String url=a.getUrl();
        holder.mtextView.setText(a.getTitle());
        //get source ke saath .getname lagana hai 32.36 part 1
        holder.mauthorView.setText(a.getAuthor());

        String imageUrl=a.getUrlToImage();
        //picasso ka syntax new 33.07 part1
        Picasso.get().load(imageUrl).into(holder.mimageView);
        holder.mimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,feedActivity.class);
                intent.putExtra("title",a.getTitle());
                intent.putExtra("Author",a.getAuthor());
                intent.putExtra("imageUrl",a.getUrlToImage());
                intent.putExtra("url",a.getUrl());
                intent.putExtra("desc",a.getdesc());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
