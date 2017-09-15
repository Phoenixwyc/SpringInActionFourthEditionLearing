package cn.seu.edu.spring.chapter3.externals;

import cn.seu.edu.spring.chapter3.externals.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by Administrator on 2017/9/15.
 */
@Configuration
public class EnvironmentConfigWithDefaults {
    @Autowired
    Environment environment;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(
                environment.getProperty("disc.title", "Rattle and Hum"),
                environment.getProperty("disc.artist", "U2"));
    }
}
