package cn.seu.edu.spring.chapter4.soundsystem;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
public class BlankDisc implements CompactDisc{
    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc() {}

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play(int trackNumber) {
        System.out.print("Playing " + title + " by " + artist);
        String track = tracks.get(trackNumber);
        System.out.print("-Track: " + track);

    }
}
