package cn.seu.edu.spring.chapter2.xmlconfig.collections;

import cn.seu.edu.spring.chapter2.xmlconfig.CompactDisc;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
public class BlankDisc implements CompactDisc{
    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }
    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }
}
