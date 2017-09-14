package cn.seu.edu.spring.chapter2.xmlconfig.test;

import cn.seu.edu.spring.chapter2.xmlconfig.MediaPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2017/9/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/cn/seu/edu/spring/chapter2/xmlconfig/XMLS/PNameSpaceValueTest-context.xml")
public class PNameSpaceVlaueTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;

    @Test
    public void play() {
        player.play();
        assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles" +
                        "-Track: Sgt. Pepper's Lonely Hearts Club Band" +
                        "-Track: With a Little Help from My Friends" +
                        "-Track: Lucy in the Sky with Diamonds" +
                        "-Track: Getting Better" +
                        "-Track: Fixing a Hole" +
                        "-Track: She's Leaving Home" +
                        "-Track: Being for the Benefit of Mr. Kite!" +
                        "-Track: Within You Without You" +
                        "-Track: When I'm Sixty-Four" +
                        "-Track: Lovely Rita" +
                        "-Track: Good Morning Good Morning" +
                        "-Track: Sgt. Pepper's Lonely Hearts Club Band (Reprise)" +
                        "-Track: A Day in the Life",
                log.getLog());
    }
}
