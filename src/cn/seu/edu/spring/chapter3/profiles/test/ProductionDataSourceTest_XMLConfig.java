package cn.seu.edu.spring.chapter3.profiles.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/cn/seu/edu/spring/chapter3/profiles/datasource-config.xml")
@ActiveProfiles("prod")
public class ProductionDataSourceTest_XMLConfig {
    @Autowired(required=false)
    private DataSource dataSource;

    @Test
    public void shouldBeEmbeddedDatasource() {
        // should be null, because there isn't a datasource configured in JNDI
        Assert.assertNull(dataSource);
    }
}

