package cn.seu.edu.spring.chapter3.externals.test;

import cn.seu.edu.spring.chapter3.externals.BlankDisc;
import cn.seu.edu.spring.chapter3.externals.EnvironmentConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EnvironmentConfig.class)
public class EnvironmentConfigTest {

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void assertBlankDiscProperties() {
        Assert.assertEquals("The Beatles", blankDisc.getArtist());
        Assert.assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
    }
}
