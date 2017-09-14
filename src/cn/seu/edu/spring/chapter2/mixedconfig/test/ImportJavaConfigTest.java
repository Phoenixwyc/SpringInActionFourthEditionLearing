package cn.seu.edu.spring.chapter2.mixedconfig.test;

import cn.seu.edu.spring.chapter2.mixedconfig.MediaPlayer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/cn/seu/edu/spring/chapter2/mixedconfig/XMLS/cdplayer-config.xml")
public class ImportJavaConfigTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void play() {
        mediaPlayer.play();
        Assert.assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles",
                log.getLog());
    }
}
