package com.example.rohitlien.tryapp.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rohitlien.tryapp.R;
import com.example.rohitlien.tryapp.adapters.TabPagerAdapter;
import com.example.rohitlien.tryapp.adapters.VideoPagerAdapter;
import com.example.rohitlien.tryapp.fragments.ImageFragment;
import com.example.rohitlien.tryapp.fragments.MilestoneFragment;
import com.example.rohitlien.tryapp.fragments.VideoFragment;

public class MainActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager tabPager,videoPager;

    private int[] tabIcons = {
            R.drawable.video,
            R.drawable.image,
            R.drawable.milestone,
            R.drawable.select_video,
            R.drawable.select_image,
            R.drawable.select_milestone
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(R.layout.activity_main);

        initViews();
        setupVideoPager();
        setupViewTabPager();
        setTabs();

    }

    private void setupVideoPager() {
        VideoPagerAdapter videoPageAdapter=new VideoPagerAdapter(getSupportFragmentManager());
        videoPager.setAdapter(videoPageAdapter);
    }

    private void setTabs() {
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));
        tabLayout.addTab(tabLayout.newTab().setText("Images"));
        tabLayout.addTab(tabLayout.newTab().setText("Milestone"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(tabPager);


        tabPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabPager.setCurrentItem(tab.getPosition());
                setupTabIcons(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setupTabIcons(0);
    }


    private void setupViewTabPager() {
        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new VideoFragment(), "Videos");
        adapter.addFrag(new ImageFragment(), "Images");
        adapter.addFrag(new MilestoneFragment(), "Milestone");
        tabPager.setAdapter(adapter);
    }

    private void initViews() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabPager = (ViewPager) findViewById(R.id.pager);
        videoPager=(ViewPager)findViewById(R.id.video_pager);
    }

    private void setupTabIcons(int position) {
        switch (position) {
            case 0:
                tabLayout.getTabAt(0).setIcon(tabIcons[3]);
                tabLayout.getTabAt(1).setIcon(tabIcons[1]);
                tabLayout.getTabAt(2).setIcon(tabIcons[2]);
                break;
            case 1:
                tabLayout.getTabAt(0).setIcon(tabIcons[0]);
                tabLayout.getTabAt(1).setIcon(tabIcons[4]);
                tabLayout.getTabAt(2).setIcon(tabIcons[2]);
                break;
            case 2:
                tabLayout.getTabAt(0).setIcon(tabIcons[0]);
                tabLayout.getTabAt(1).setIcon(tabIcons[1]);
                tabLayout.getTabAt(2).setIcon(tabIcons[5]);
                break;
        }
    }
}
