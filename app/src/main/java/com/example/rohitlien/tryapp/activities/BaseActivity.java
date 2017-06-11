package com.example.rohitlien.tryapp.activities;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.rohitlien.tryapp.R;
import com.example.rohitlien.tryapp.fragments.NavigationDrawerFragment;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    protected FrameLayout frameLayout;
    protected NavigationDrawerFragment navFragment;
    protected DrawerLayout mDrawerLayout;
    protected Toolbar mToolbar;
    protected NavigationView navigationView;
    protected TextView topbar_title, topbar_info;
    FragmentManager fragmentManager;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        frameLayout = (FrameLayout) findViewById(R.id.content_layout);
        fragmentManager = getFragmentManager();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initDrawer();
    }


    @Override
    protected void onResume() {
        super.onResume();
        closeDrawer();
    }

    public void initContentView(int layout) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);
        frameLayout.addView(view);
    }

    private void initDrawer() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null)
            setSupportActionBar(mToolbar);
        topbar_title = (TextView) findViewById(R.id.topbar_title);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        navFragment.setUp(mDrawerLayout, mToolbar, (View) findViewById(R.id.fragment));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        closeDrawer();
        super.onBackPressed();
    }

    private void closeDrawer() {
        if (mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.dashboard:
                mDrawerLayout.closeDrawers();

                break;

            case R.id.reward:
                mDrawerLayout.closeDrawers();
                break;

            case R.id.contact:
                mDrawerLayout.closeDrawers();
                break;
            case R.id.faq:
                mDrawerLayout.closeDrawers();
                break;
            case R.id.aboutus:
                mDrawerLayout.closeDrawers();
                break;
            case R.id.nav_logout:
                mDrawerLayout.closeDrawers();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

    }
}
