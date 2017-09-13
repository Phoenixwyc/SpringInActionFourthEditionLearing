package cn.seu.edu.spring.chapter2.xmlconfig.properties;

import cn.seu.edu.spring.chapter2.xmlconfig.CompactDisc;
import cn.seu.edu.spring.chapter2.xmlconfig.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/9/13.
 */
public class CDPlayer implements MediaPlayer{
    private CompactDisc compactDisc;

    @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}
