package com.zcreen.fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zcreen.R;
import com.zcreen.adapter.SurveysAdapter;
import com.zcreen.widget.DividerItemDecoration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mertkanuzunparmak on 10/04/16.
 * mertkan@mobilike.com
 */
public class SurveyFragment extends Fragment {

    private RecyclerView recyclerView;
    private SurveysAdapter adapter;
    private List<String> surveys;

    public static SurveyFragment newInstance() {
        return new SurveyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_survey_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Resources res = getResources();
        String[] cities = res.getStringArray(R.array.surveys);

        surveys = Arrays.asList(cities);

        // TODO RecyclerView implementation should be moved to an abstract class for fragments
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setAutoMeasureEnabled(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new SurveysAdapter(getActivity(), surveys);
        recyclerView.setAdapter(adapter);
    }
}
