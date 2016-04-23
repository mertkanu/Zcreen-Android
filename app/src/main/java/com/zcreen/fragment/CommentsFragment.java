package com.zcreen.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zcreen.R;
import com.zcreen.adapter.CommentsAdapter;
import com.zcreen.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mertkanuzunparmak on 10/04/16.
 * mertkan@mobilike.com
 */
public class CommentsFragment extends Fragment {

    public static CommentsFragment newInstance() {
        return new CommentsFragment();
    }

    private RecyclerView recyclerView;
    private List<String> comments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_comments_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        comments = new ArrayList<>();
        for (int i = 0; i < 120; i ++) {
            comments.add(new Random() + "asd");
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setAutoMeasureEnabled(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setLayoutManager(linearLayoutManager);

        CommentsAdapter adapter = new CommentsAdapter(getActivity(), comments);

        recyclerView.setAdapter(adapter);

    }
}
