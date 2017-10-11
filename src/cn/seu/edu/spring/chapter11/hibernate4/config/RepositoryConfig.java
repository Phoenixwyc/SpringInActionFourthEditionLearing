package cn.seu.edu.spring.chapter11.hibernate4.config;

import cn.seu.edu.spring.chapter11.hibernate4.hibernate4.HibernateSpitterRepository;
import cn.seu.edu.spring.chapter11.hibernate4.hibernate4.HibernateSpittleRepository;
import cn.seu.edu.spring.chapter11.hibernate4.repository.SpitterRepository;
import cn.seu.edu.spring.chapter11.hibernate4.repository.SpittleRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/9/22.
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
@ImportResource("/cn/seu/edu/spring/chapter11/hibernate4/test/repository-config.xml")
public class RepositoryConfig {

    @Autowired
    private SessionFactory sessionFactory;

//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
//        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
//        embeddedDatabaseBuilder.addScript("/cn/seu/edu/spring/chapter11/hibernate4/sql/schema.sql");
//        embeddedDatabaseBuilder.addScript("/cn/seu/edu/spring/chapter11/hibernate4/sql/test-data.sql");
//        EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.build();
//        return embeddedDatabase;
//    }

//    @Bean
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        System.out.println(sessionFactory);
//        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//        hibernateTransactionManager.setSessionFactory(sessionFactory);
//        return  hibernateTransactionManager;
//    }

//    @Bean
//    public SessionFactory sessionFactoryBean() {
//        try {
//            LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
//            localSessionFactoryBean.setDataSource(dataSource());
//            localSessionFactoryBean.setPackagesToScan("cn.seu.edu.spring.chapter11.hibernate4.domain");
//            Properties properties = new Properties();
//            properties.put("dialect", "org.hibernate.dialect.H2Dialect");
//            localSessionFactoryBean.setHibernateProperties(properties);
//            localSessionFactoryBean.afterPropertiesSet();
//            SessionFactory factory = localSessionFactoryBean.getObject();
//            return  factory;
//        } catch (IOException e) {
//            return null;
//        }
//    }

//    @Bean
//    public SpitterRepository spitterRepository() {
//        return new HibernateSpitterRepository(sessionFactory);
//    }
//
//    @Bean
//    public SpittleRepository spittleRepository() {
//        return new HibernateSpittleRepository(sessionFactory);
//    }
}
