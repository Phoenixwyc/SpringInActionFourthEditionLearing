package cn.seu.edu.spring.chapter2.mixedconfig;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public class BlankDisc implements CompactDisc{
    private String artist;
    private String title;
    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.print("-Track: " + track);
        }
    }
}
