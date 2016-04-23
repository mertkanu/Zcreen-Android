package com.zcreen.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zcreen.R;
import com.zcreen.adapter.TvGuideAdapter;
import com.zcreen.core.BaseActivity;
import com.zcreen.model.Manifest;
import com.zcreen.utility.RecyclerViewItemClickUtil;
import com.zcreen.widget.DividerItemDecoration;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(new TvGuideAdapter(MainActivity.this));

        RecyclerViewItemClickUtil.addTo(recyclerView).
                setOnItemClickListener(new RecyclerViewItemClickUtil.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View view) {

                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        ActivityOptionsCompat options = null;
                        if (view != null && view instanceof ViewGroup) {
                            if (((ViewGroup) view).getChildCount() > 0) {
                                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                                    View imageView = ((ViewGroup) view).getChildAt(i);
                                    if (imageView instanceof ImageView) {
                                        options = ActivityOptionsCompat
                                                .makeSceneTransitionAnimation(MainActivity.this, imageView, "showPhoto");
                                    }
                                }
                            }
                        }
                        intent.putExtra("showImage",Manifest.get().getTvGuideList().get(position).getImageUrl());
                        if (options != null) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                startActivity(intent, options.toBundle());
                            }
                            else {
                                startActivity(intent);
                            }
                        }
                        else {
                            startActivity(intent);
                        }

                    }
                });
    }

    @Override
    protected void onNavigationDrawerStateChanged(boolean isOpen, boolean isAnimating) {

    }
}
