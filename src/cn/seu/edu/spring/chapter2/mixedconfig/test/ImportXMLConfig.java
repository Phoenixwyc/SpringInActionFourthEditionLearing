package cn.seu.edu.spring.chapter2.mixedconfig.test;

import cn.seu.edu.spring.chapter2.mixedconfig.MediaPlayer;
import cn.seu.edu.spring.chapter2.mixedconfig.SoundSystemConfig;
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
@ContextConfiguration(classes=SoundSystemConfig.class)
public class ImportXMLConfig {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;


    @Test
    public void play() {
        player.play();
        Assert.assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n" +
                        "-Track: Sgt. Pepper's Lonely Hearts Club Band\n" +
                        "-Track: With a Little Help from My Friends\n" +
                        "-Track: Lucy in the Sky with Diamonds\n" +
                        "-Track: Getting Better\n" +
                        "-Track: Fixing a Hole\n",
                log.getLog());
    }

}
