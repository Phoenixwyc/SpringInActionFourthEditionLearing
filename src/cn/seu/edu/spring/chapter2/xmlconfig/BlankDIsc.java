package cn.seu.edu.spring.chapter2.xmlconfig;

/**
 * Created by Administrator on 2017/9/13.
 */
public class BlankDIsc implements CompactDisc{
    private String title;
    private String artist;

    public BlankDIsc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
    }
}
