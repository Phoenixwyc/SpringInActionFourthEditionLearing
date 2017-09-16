package cn.seu.edu.spring.chapter3.scopebeans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Administrator on 2017/9/15.
 */
@Configuration
public class ExplictConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public NotePad notePad() {
        return new NotePad();
    }

    @Bean
    public UniqueThing uniqueThing() {
        return new UniqueThing();
    }
}
