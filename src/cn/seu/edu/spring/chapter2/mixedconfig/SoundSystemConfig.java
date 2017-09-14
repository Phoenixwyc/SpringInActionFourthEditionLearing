package cn.seu.edu.spring.chapter2.mixedconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2017/9/14.
 */
@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("/cn/seu/edu/spring/chapter2/mixedconfig/XMLS/cd-config.xml")
public class SoundSystemConfig {
}
