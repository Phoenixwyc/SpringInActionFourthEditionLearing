package cn.seu.edu.spring.chapter3.externals;

/**
 * Created by Administrator on 2017/9/15.
 */
public class BlankDisc {
    private final String title;
    private final String artist;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
}
