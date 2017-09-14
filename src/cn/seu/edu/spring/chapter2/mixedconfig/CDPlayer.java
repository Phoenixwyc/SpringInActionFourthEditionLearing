package cn.seu.edu.spring.chapter2.mixedconfig;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/9/14.
 */
public class CDPlayer implements MediaPlayer{
    private CompactDisc compactDisc;

    @Autowired
    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }
    @Override
    public void play() {
        compactDisc.play();
    }
}
