package basePackage.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("basePackage")
public class Config {

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        Properties properties = new Properties();
        properties.setProperty("show_sql", "false");
        properties.setProperty("hbm2ddl.auto","create-drop");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/Database_H2/Spitter");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");
        return dataSource;
    }
}
