package com.zcreen.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zcreen.R;
import com.zcreen.core.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertkanuzunparmak on 10/04/16.
 * mertkan@mobilike.com
 */
public class CommentsAdapter extends BaseRecyclerAdapter<CommentsAdapter.ViewHolder> {

    private List<String> comments;
    private Context context;

    public CommentsAdapter(Context context, List<String> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_comments, parent, false);
        return new ViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String comment = comments.get(position);
        holder.comment.setText(comment);
        Picasso.with(context).load(R.mipmap.ic_launcher).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView comment;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            comment = (TextView) itemView.findViewById(R.id.list_item_comments_comment_textView);
            imageView = (ImageView) itemView.findViewById(R.id.list_item_user_display_photo);

        }
    }
}
