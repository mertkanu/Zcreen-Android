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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zcreen.R;
import com.zcreen.adapter.CommentsAdapter;
import com.zcreen.widget.DividerItemDecoration;

import java.util.Arrays;
import java.util.List;

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
    private FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_comments_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Resources res = getResources();
        String[] cities = res.getStringArray(R.array.comments);

        comments = Arrays.asList(cities);

        // TODO RecyclerView implementation should be moved to an abstract class for fragments
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setAutoMeasureEnabled(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setLayoutManager(linearLayoutManager);

        final CommentsAdapter adapter = new CommentsAdapter(getActivity(), comments);

        recyclerView.setAdapter(adapter);

        floatingActionButton = (FloatingActionButton) getActivity().findViewById(R.id.floating_action_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.layout_comment_dialog);
                TextView title = (TextView) dialog.findViewById(R.id.comment_dialog_title);
                title.setText("Yorum yazın..");
                final EditText editText = (EditText) dialog.findViewById(R.id.comment_dialog_comment_edit_text);


                Button dialogButton = (Button) dialog.findViewById(R.id.comment_dialog_send_button);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
}
