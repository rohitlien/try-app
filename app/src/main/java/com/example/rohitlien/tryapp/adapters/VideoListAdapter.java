package com.example.rohitlien.tryapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohitlien.tryapp.R;
import com.example.rohitlien.tryapp.models.VideoModel;

import java.util.ArrayList;

/**
 * Created by rohitlien on 11/6/17.
 */

public class VideoListAdapter extends BaseAdapter {
    private ArrayList<VideoModel> videoModels;
    private Context context;
    private LayoutInflater inflater;

    public VideoListAdapter(ArrayList<VideoModel> videoModels, Context context) {
        this.videoModels = videoModels;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return videoModels.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.video_item,parent,false);
            viewHolder.videoName=(TextView)convertView.findViewById(R.id.video_name);
            viewHolder.videoDescription=(TextView)convertView.findViewById(R.id.video_description);
            viewHolder.videoTimeStamp=(TextView)convertView.findViewById(R.id.video_timestamp);
            viewHolder.videoImage=(ImageView) convertView.findViewById(R.id.thumbnail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        VideoModel videoModel=videoModels.get(position);
        if(videoModel!=null){
            viewHolder.videoName.setText(""+videoModel.getVideoName());
            viewHolder.videoDescription.setText(""+videoModel.getDescription());
            viewHolder.videoTimeStamp.setText(""+videoModel.getTimeStamp());
            viewHolder.videoImage.setImageResource(videoModel.getVidImage());

        }

        return convertView;
    }
    public class ViewHolder{
        TextView videoName,videoDescription,videoTimeStamp;
        ImageView videoImage;
    }
}
