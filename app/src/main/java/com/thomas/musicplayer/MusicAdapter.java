package com.thomas.musicplayer;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by thomas on 15-11-29.
 *
 * MusicAdapter:适配器类，继承自BaseAdapter，
 * 用来将想要在音乐列表显示的MusicInfo属性和ListView适配，
 * 在构造方法中初始化List<MusicInfo>作为数据源，将扫描得到
 * 的音乐对象放入List<MusicInfo>中，最后通过适配器与lisiview
 * 完成适配。
 */
public class MusicAdapter extends BaseAdapter {

    public Context context;
    public static List<MusicInfo> musicInfos;
    public MusicInfo musicInfo;
    public int i=1;
    public LayoutInflater inflater;


    public MusicAdapter(Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);

        musicInfos = new ArrayList<MusicInfo>();


        String str[] = { MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DISPLAY_NAME};
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, str,
                null, null, MediaStore.Audio.Media.DISPLAY_NAME);

        while (cursor.moveToNext()&&cursor.getString(4).endsWith("mp3")) {

            musicInfo = new MusicInfo();
            musicInfo.setIndx(i++);
            musicInfo.setTitle(cursor.getString(0));
            musicInfo.setArtist("@"+cursor.getString(1));
            musicInfo.setPath(cursor.getString(2));
            Date date = new Date(cursor.getLong(3));
            SimpleDateFormat format = new SimpleDateFormat("mm:ss");
            musicInfo.setDuration(format.format(date));
            musicInfo.setDisplayname(cursor.getString(4));
            musicInfos.add(musicInfo);

        }


    }



    @Override
    public int getCount() {
        return musicInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return musicInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.itembean,null);
            viewHolder.textView_title = (TextView)convertView.findViewById(R.id.Id_title);
            viewHolder.textView_artist = (TextView)convertView.findViewById(R.id.Id_artist);
            viewHolder.textView_duration = (TextView)convertView.findViewById(R.id.Id_duration);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder =(ViewHolder)convertView.getTag();
        }

        musicInfo = musicInfos.get(position);
        viewHolder.textView_title.setText(musicInfo.getIndx()+"."+musicInfo.getTitle());
        viewHolder.textView_artist.setText(musicInfo.getArtist());
        viewHolder.textView_duration.setText(musicInfo.getDuration());
        return convertView;
    }

    class ViewHolder{
        public TextView textView_title;
        public TextView textView_artist;
        public TextView textView_duration;
    }


}
