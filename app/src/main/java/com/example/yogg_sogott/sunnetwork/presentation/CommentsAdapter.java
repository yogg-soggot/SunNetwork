package com.example.yogg_sogott.sunnetwork.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yogg_sogott.sunnetwork.R;
import com.example.yogg_sogott.sunnetwork.data.CommentDTO;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    private List<CommentDTO> data;

    public CommentsAdapter(List<CommentDTO> data){
        this.data = data;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView user;
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user_name_comment);
            text = itemView.findViewById(R.id.comment_text);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_comment,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,int i){
        String username = data.get(i).getUserLogin();
        String post_text = data.get(i).getBody();
        viewHolder.user.setText(username);
        viewHolder.text.setText(post_text);
    }

    @Override
    public int getItemCount(){
        return data.size();
    }
}
