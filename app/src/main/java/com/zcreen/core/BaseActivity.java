package com.zcreen.core;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zcreen.R;

/**
 * Created by mertkanuzunparmak on 16/02/16.
 * mertkan@mobilike.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mActionBarToolbar;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if(isNavigationDrawerOpen()) {
            closeNavigationDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        getActionBarToolbar();
        setupNavigationDrawer();
    }

    /**
     * Can be used by subclasses for custom behavior
     *
     * @param isOpen
     * @param isAnimating
     */
    protected abstract void onNavigationDrawerStateChanged(boolean isOpen, boolean isAnimating);

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
            if (mActionBarToolbar != null) {
                setSupportActionBar(mActionBarToolbar);

            }
        }
        return mActionBarToolbar;
    }

    protected boolean isNavigationDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavigationDrawer() {
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    private void setupNavigationDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);

        if (mDrawerLayout == null) {
            return;
        }

        if (mNavigationView == null) {
            return;
        }

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mActionBarToolbar,
                R.string.openDrawerContentDesc, R.string.closeDrawerContentDesc) {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                onNavigationDrawerStateChanged(true, false);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                onNavigationDrawerStateChanged(false, false);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                onNavigationDrawerStateChanged(isNavigationDrawerOpen(), newState != DrawerLayout.STATE_IDLE);
            }

        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

}
