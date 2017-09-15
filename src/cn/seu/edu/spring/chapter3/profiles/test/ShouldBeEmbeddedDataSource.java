package cn.seu.edu.spring.chapter3.profiles.test;

import cn.seu.edu.spring.chapter3.profiles.DataSourceConfig;
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
@ContextConfiguration(classes = DataSourceConfig.class)
@ActiveProfiles("dev")
public class ShouldBeEmbeddedDataSource {
    @Autowired
    DataSource dataSource;

    @Test
    @SuppressWarnings("all")
    public void shouldBeEmbeddedDataSource() {
        Assert.assertNotNull(dataSource);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> result = jdbcTemplate.query("select id, name from Things", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getLong("id") + ":" + resultSet.getString("name");
            }
        });

        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1:A", result.get(0));
    }
}
