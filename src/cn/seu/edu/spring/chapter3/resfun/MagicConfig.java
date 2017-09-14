package cn.seu.edu.spring.chapter3.resfun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/9/14.
 */
@Configuration
public class MagicConfig {
    @Bean
    @Conditional(MagicExitsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
