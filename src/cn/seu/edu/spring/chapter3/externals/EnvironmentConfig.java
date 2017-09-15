package cn.seu.edu.spring.chapter3.externals;

import cn.seu.edu.spring.chapter3.externals.BlankDisc;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by Administrator on 2017/9/15.
 */
@Configuration
@PropertySource("/cn/seu/edu/spring/chapter3/externals/app.properties")
public class EnvironmentConfig {
    @Autowired
    Environment environment;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(environment.getProperty("disc.title"), environment.getProperty("disc.artist"));
    }
}
