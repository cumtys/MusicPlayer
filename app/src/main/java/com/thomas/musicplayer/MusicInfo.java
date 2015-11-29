package com.thomas.musicplayer;

/**
 * Created by thomas on 15-11-29.
 *
 *
 * MisicInfo 即音乐对象，每个成员变量都对应音乐的不同属性。
 */
public class MusicInfo {

    private String title;//对应音乐的标题
    private String artist;//艺术家
    private String path;//这是音乐存放再本地的路径
    private String displayname;//音乐文件显示的名称
    private String   duration;//音乐时常 以毫秒表示，之后会换算成 mm：ss 的格式
    private int    indx;//音乐在播放列表里的序号


    public MusicInfo() {
    }

    /**setXX()和geiXX()方法用来设置音乐属性和获得音乐属性**/


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
