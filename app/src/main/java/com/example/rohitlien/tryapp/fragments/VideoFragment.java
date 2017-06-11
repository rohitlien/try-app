package com.example.rohitlien.tryapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rohitlien.tryapp.R;
import com.example.rohitlien.tryapp.adapters.VideoListAdapter;
import com.example.rohitlien.tryapp.models.VideoModel;
import com.example.rohitlien.tryapp.views.CustomListView;

import java.util.ArrayList;

/**
 * Created by rohitlien on 11/6/17.
 */

public class VideoFragment extends Fragment {

    ListView videoListView;
    private ArrayList<VideoModel> videoModels;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_videos,container,false);
        
        videoListView=(ListView)view.findViewById(R.id.video_list_view);
        setAdapter();
        return view;
    }

    private void setAdapter() {
        videoModels=new ArrayList<>();

        VideoModel videoModel=new VideoModel();
        videoModel.setVideoName("EMPTINESS FT. JUSTIN TIBLEKAR");
        videoModel.setDescription("Lorem ipsumis simply the dummy text industry");
        videoModel.setArtist("Justin Tiblekar");
        videoModel.setTimeStamp("18 HOURS");
        videoModel.setVidImage(R.drawable.girl);
        videoModels.add(videoModel);

        VideoModel videoModel1=new VideoModel();
        videoModel1.setVideoName("I'M FALLING IN LOVE WITH YOU");
        videoModel1.setDescription("Lorem ipsumis simply the dummy text industry");
        videoModel1.setArtist("Some singer");
        videoModel1.setTimeStamp("20 HOURS");
        videoModel1.setVidImage(R.drawable.guy);
        videoModels.add(videoModel1);

        VideoModel videoModel2=new VideoModel();
        videoModel2.setVideoName("BABY FT. JUSTIN BABER");
        videoModel2.setDescription("Lorem ipsumis simply the dummy text industry");
        videoModel2.setArtist("Justin Baber");
        videoModel2.setTimeStamp("22 HOURS");
        videoModel2.setVidImage(R.drawable.boy);
        videoModels.add(videoModel2);

        VideoModel videoModel3=new VideoModel();
        videoModel3.setVideoName("WHITE HORSE FT. TAYLOR SWIFT");
        videoModel3.setDescription("Lorem ipsumis simply the dummy text industry");
        videoModel3.setArtist("TAYLOR SWIFT");
        videoModel3.setTimeStamp("23 HOURS");
        videoModel3.setVidImage(R.drawable.girl);
        videoModels.add(videoModel3);

        VideoListAdapter videoListAdapter=new VideoListAdapter(videoModels,getActivity());
        videoListView.setAdapter(videoListAdapter);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
