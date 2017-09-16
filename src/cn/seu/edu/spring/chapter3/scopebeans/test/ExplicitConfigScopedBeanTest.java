package cn.seu.edu.spring.chapter3.scopebeans.test;

import cn.seu.edu.spring.chapter3.scopebeans.ExplictConfig;
import cn.seu.edu.spring.chapter3.scopebeans.UniqueThing;
import cn.seu.edu.spring.chapter3.scopebeans.NotePad;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExplictConfig.class)
public class ExplicitConfigScopedBeanTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testProxyScope() {
        NotePad notepad1 = applicationContext.getBean(NotePad.class);
        NotePad notepad2 = applicationContext.getBean(NotePad.class);
        Assert.assertNotSame(notepad1, notepad2);
    }

    @Test
    public void testSingletonScope() {
        UniqueThing thing1 = applicationContext.getBean(UniqueThing.class);
        UniqueThing thing2 = applicationContext.getBean(UniqueThing.class);
        Assert.assertSame(thing1, thing2);
    }

}
