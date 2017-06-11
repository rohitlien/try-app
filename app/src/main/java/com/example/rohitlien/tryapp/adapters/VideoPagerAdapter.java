package com.example.rohitlien.tryapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.rohitlien.tryapp.fragments.VideoViewFragment;
import com.example.rohitlien.tryapp.models.VideoModel;

/**
 * Created by rohitlien on 11/6/17.
 */

public class VideoPagerAdapter extends FragmentStatePagerAdapter {

    public VideoPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    private VideoModel videoModel;
    @Override
    public Fragment getItem(int position) {
        videoModel=new VideoModel();
        videoModel.setArtist("ft. Rihanna and usher");
        videoModel.setVideoName("chainSmoker new Album 2017");

        Fragment fragment = VideoViewFragment.newInstance(videoModel, position);
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
