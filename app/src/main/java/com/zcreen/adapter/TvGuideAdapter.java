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
import com.zcreen.model.Manifest;
import com.zcreen.model.TvGuide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mertkanuzunparmak on 22/03/16.
 * mertkan@mobilike.com
 */
public class TvGuideAdapter extends BaseRecyclerAdapter<TvGuideAdapter.ViewHolder> {

    final Context context;
    private List<TvGuide> tvGuideList;

    public TvGuideAdapter(Context context) {
        this.context = context;
        tvGuideList = Manifest.get().getTvGuideList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_shows, parent, false);
        return new ViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TvGuide tvGuide = tvGuideList.get(position);
        holder.tvShowName.setText(tvGuide.getShowName());
        int originalPosition = position + 1;
        holder.listPosition.setText(originalPosition + ".");
        Picasso.with(context).load(tvGuide.getImageUrl()).into(holder.tvShowImage);
    }

    @Override
    public int getItemCount() {
        return tvGuideList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView tvShowImage;
        public CircleImageView tvChannelIcon;
        public TextView tvShowName;
        public TextView tvShowType;
        public TextView airTime;
        public TextView listPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            tvShowImage = (ImageView) itemView.findViewById(R.id.list_item_tvshow_imageView);
            tvChannelIcon = (CircleImageView) itemView.findViewById(R.id.list_item_tv_icon_imageView);
            tvShowName = (TextView) itemView.findViewById(R.id.list_item_show_name_textView);
            tvShowType = (TextView) itemView.findViewById(R.id.list_item_show_type);
            airTime = (TextView) itemView.findViewById(R.id.list_item_air_timeday_textView);
            listPosition = (TextView) itemView.findViewById(R.id.list_item_position);

        }
    }
}
