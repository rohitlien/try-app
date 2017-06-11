package com.example.rohitlien.tryapp.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rohitlien.tryapp.R;
import com.example.rohitlien.tryapp.models.VideoModel;
import com.github.rtoshiro.view.video.FullscreenVideoLayout;

import java.io.IOException;

/**
 * Created by rohitlien on 11/6/17.
 */

public class VideoViewFragment extends Fragment {

    FullscreenVideoLayout videoLayout;
    private VideoModel videoModel;
    private int position;
    private TextView videoName, videoArtist;
    private LinearLayout vidoInfo_ll;
    private ImageView img1, img2, img3, img4, img5;

    public static VideoViewFragment newInstance(VideoModel videoModel, int position) {
        VideoViewFragment videoViewFragment = new VideoViewFragment();
        videoViewFragment.videoModel = videoModel;
        videoViewFragment.position = position;
        return videoViewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_view, container, false);

        videoLayout = (FullscreenVideoLayout) view.findViewById(R.id.videoview);
        videoArtist = (TextView) view.findViewById(R.id.video_artist);
        videoName = (TextView) view.findViewById(R.id.video_name);
        vidoInfo_ll = (LinearLayout) view.findViewById(R.id.info_ll);
        img1 = (ImageView) view.findViewById(R.id.img_1);
        img2 = (ImageView) view.findViewById(R.id.img_2);
        img3 = (ImageView) view.findViewById(R.id.img_3);
        img4 = (ImageView) view.findViewById(R.id.img_4);
        img5 = (ImageView) view.findViewById(R.id.img_5);

        //videoLayout.setActivity(getActivity());
        videoArtist.setText("" + videoModel.getArtist());
        videoName.setText("" + videoModel.getVideoName());
        videoLayout.hideControls();

        Uri videoUri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        try {
            videoLayout.setVideoPath("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");

        } catch (IOException e) {
            e.printStackTrace();
        }

        vidoInfo_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoLayout != null) {
                    vidoInfo_ll.setVisibility(View.GONE);
                    videoLayout.showControls();
                }
            }
        });

        setVideoIndex();

        if(videoLayout!=null){
            videoLayout.seekTo(3000);
        }

        return view;
    }

    private void setVideoIndex() {
        switch (position) {
            case 0:
                img1.setImageResource(R.drawable.red_dot);
                img2.setImageResource(R.drawable.white_dot);
                img3.setImageResource(R.drawable.white_dot);
                img4.setImageResource(R.drawable.white_dot);
                img5.setImageResource(R.drawable.white_dot);
                break;
            case 1:
                img1.setImageResource(R.drawable.white_dot);
                img2.setImageResource(R.drawable.red_dot);
                img3.setImageResource(R.drawable.white_dot);
                img4.setImageResource(R.drawable.white_dot);
                img5.setImageResource(R.drawable.white_dot);
                break;
            case 2:
                img1.setImageResource(R.drawable.white_dot);
                img2.setImageResource(R.drawable.white_dot);
                img3.setImageResource(R.drawable.red_dot);
                img4.setImageResource(R.drawable.white_dot);
                img5.setImageResource(R.drawable.white_dot);
                break;
            case 3:
                img1.setImageResource(R.drawable.white_dot);
                img2.setImageResource(R.drawable.white_dot);
                img3.setImageResource(R.drawable.white_dot);
                img4.setImageResource(R.drawable.red_dot);
                img5.setImageResource(R.drawable.white_dot);
                break;
            case 4:
                img1.setImageResource(R.drawable.white_dot);
                img2.setImageResource(R.drawable.white_dot);
                img3.setImageResource(R.drawable.white_dot);
                img4.setImageResource(R.drawable.white_dot);
                img5.setImageResource(R.drawable.red_dot);
                break;
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser) {
            if (videoLayout != null) {
                videoLayout.pause();
            }
        }
    }
}
