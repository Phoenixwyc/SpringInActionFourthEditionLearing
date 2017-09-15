package cn.seu.edu.spring.chapter3.externals.test;

import cn.seu.edu.spring.chapter3.externals.EnvironmentConfigWithReuqiredProperties;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017/9/15.
 */
public class EnvironmentConfigWithRequiredPropertiesTest {
    @Test(expected = BeanCreationException.class)
    public void assertBlankDiscProperties() {
        new AnnotationConfigApplicationContext(EnvironmentConfigWithReuqiredProperties.class);
    }
}
