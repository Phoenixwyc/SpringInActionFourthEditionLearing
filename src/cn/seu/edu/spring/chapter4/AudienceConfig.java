package cn.seu.edu.spring.chapter4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Administrator on 2017/9/16.
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AudienceConfig {
    @Bean
    public Audience audience() {
        return new Audience();
    }

}
