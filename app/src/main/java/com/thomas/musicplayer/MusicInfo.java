package com.thomas.musicplayer;

/**
 * Created by thomas on 15-11-29.
 */
public class MusicInfo {

    private String title;
    private String artist;
    private String path;
    private String displayname;
    private String   duration;
    private int    indx;


    public MusicInfo() {
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public void setIndx(int indx) {
        this.indx = indx;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getPath() {
        return path;
    }

    public String getArtist() {
        return artist;
    }

    public String getDisplayname() {
        return displayname;
    }

    public int getIndx() {
        return indx;
    }
}
