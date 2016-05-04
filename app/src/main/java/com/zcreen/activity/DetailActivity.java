package com.zcreen.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zcreen.R;
import com.zcreen.adapter.DetailPageAdapter;

/**
 * Created by mertkanuzunparmak on 06/04/16.
 * mertkan@mobilike.com
 */
public class DetailActivity extends AppCompatActivity {

    private ImageView showImage;
    private String imageUrl;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("");

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            imageUrl = (String) bundle.get("showImage");
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new DetailPageAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        showImage = (ImageView) findViewById(R.id.detail_activity_image_eventImage);
        Picasso.with(this).load(imageUrl).into(showImage);
    }
}
