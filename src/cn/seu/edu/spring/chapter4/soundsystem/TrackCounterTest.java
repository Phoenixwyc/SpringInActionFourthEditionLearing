package cn.seu.edu.spring.chapter4.soundsystem;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/9/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void testTackCounter() {
        compactDisc.play(1);
        compactDisc.play(2);
        compactDisc.play(3);
        compactDisc.play(3);
        compactDisc.play(3);
        compactDisc.play(2);
        compactDisc.play(2);
        compactDisc.play(1);

        Assert.assertEquals(2, trackCounter.getPlayCount(1));
        Assert.assertEquals(3, trackCounter.getPlayCount(2));
        Assert.assertEquals(3, trackCounter.getPlayCount(3));
        Assert.assertEquals(0, trackCounter.getPlayCount(5));
    }
}
