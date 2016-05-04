package com.zcreen.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zcreen.R;
import com.zcreen.core.BaseRecyclerAdapter;

import java.util.List;

/**
 * Created by mertkanuzunparmak on 10/04/16.
 * mertkan@mobilike.com
 */
public class SurveysAdapter extends BaseRecyclerAdapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_SURVEY = 0;
    private static final int VIEW_TYPE_SURVEY_LIST = 0;

    private List<String> surveys;
    private Context context;

    public SurveysAdapter(Context context, List<String> surveys) {
        this.context = context;
        this.surveys = surveys;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return VIEW_TYPE_SURVEY;
            default:
                return VIEW_TYPE_SURVEY_LIST;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout;
        switch (viewType) {
            case VIEW_TYPE_SURVEY:
                itemLayout = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_episode_survey, parent, false);
                return new SurveyViewHolder(itemLayout);
            default:
                itemLayout = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_survey, parent, false);
                return new ListViewHolder(itemLayout);
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ListViewHolder) {
            ListViewHolder listViewHolder = (ListViewHolder) holder;
            String survey = surveys.get(position);
            listViewHolder.title.setText(survey);
            int originalPosition = position + 1;
            listViewHolder.position.setText(originalPosition + ".");
        } else {
            SurveyViewHolder surveyViewHolder = (SurveyViewHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return surveys.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        public TextView position;
        public TextView title;

        public ListViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.list_item_survey_title);
            position = (TextView) itemView.findViewById(R.id.list_item_survey_position);

        }
    }

    public static class SurveyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearLayout;

        public SurveyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
