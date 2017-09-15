package cn.seu.edu.spring.chapter3.externals;

import cn.seu.edu.spring.chapter3.externals.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by Administrator on 2017/9/15.
 */
@Configuration
public class EnvironmentConfigWithReuqiredProperties {

    @Autowired
    Environment environment;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(
                environment.getRequiredProperty("disc.title"),
                environment.getRequiredProperty("disc.artist"));
    }
}
