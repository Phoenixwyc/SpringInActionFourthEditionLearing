package cn.seu.edu.spring.chapter3.resfun.test;

import cn.seu.edu.spring.chapter3.resfun.MagicConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicConfig.class)
public class MagicExitsTest {

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void shouldNoNull() {
        Assert.assertFalse(applicationContext.containsBean("magic"));
    }
}
