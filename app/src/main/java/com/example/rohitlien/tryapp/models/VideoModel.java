package com.example.rohitlien.tryapp.models;

import android.graphics.drawable.Drawable;

/**
 * Created by rohitlien on 11/6/17.
 */

public class VideoModel {
    private String videoName,timeStamp,description,artist;
    private int vidImage;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getVidImage() {
        return vidImage;
    }

    public void setVidImage(int vidImage) {
        this.vidImage = vidImage;
    }
}
