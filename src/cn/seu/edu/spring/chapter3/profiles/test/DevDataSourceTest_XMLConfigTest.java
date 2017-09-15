package cn.seu.edu.spring.chapter3.profiles.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/cn/seu/edu/spring/chapter3/profiles/datasource-config.xml")
@ActiveProfiles("dev")
public class DevDataSourceTest_XMLConfigTest {
    @Autowired
    private DataSource dataSource;

    @Test
    @SuppressWarnings("all")
    public void shouldBeEmbeddedDatasource() {
        Assert.assertNotNull(dataSource);
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        List<String> results = jdbc.query("select id, name from Things", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getLong("id") + ":" + rs.getString("name");
            }
        });

        Assert.assertEquals(1, results.size());
        Assert.assertEquals("1:A", results.get(0));
    }
}
