package cn.seu.edu.spring.chapter2.xmlconfig;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/9/13.
 */
public class CDPlayer implements MediaPlayer{
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
