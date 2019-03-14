package com.example.yogg_sogott.sunnetwork.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yogg_sogott.sunnetwork.R;
import com.example.yogg_sogott.sunnetwork.data.PostDTO;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<PostDTO> data;

    private int id;

    public MyAdapter(List<PostDTO> data) {
        this.data = data;

    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView user;
        TextView text;
        ImageView comments;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user_name);
            text = itemView.findViewById(R.id.post_text);
            comments = itemView.findViewById(R.id.comments);


        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post, viewGroup, false);
        return new ViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i){
        String username = data.get(i).getUserLogin();
        String post_text = data.get(i).getBody();
        viewHolder.user.setText(username);
        viewHolder.text.setText(post_text);
        viewHolder.comments.setTag(data.get(i).getId());
        viewHolder.comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = Integer.parseInt(v.getTag().toString());

                Intent intent = new Intent(v.getContext(), CommentsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("post_id",id);
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void addPost(PostDTO post){
        data.add(post);
        notifyDataSetChanged();
    }









}



