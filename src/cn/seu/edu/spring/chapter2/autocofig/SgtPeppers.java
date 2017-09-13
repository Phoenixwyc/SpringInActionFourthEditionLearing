package cn.seu.edu.spring.chapter2.autocofig;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/11.
 */
@Component
public class SgtPeppers implements CompactDisc{
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
    }
}
