package basePackage.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("basePackage")
@ImportResource("classpath:app-context-txAnnotation.xml")
public class Config {

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSourcePostgres());
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        return jpaTransactionManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryEmf = new LocalContainerEntityManagerFactoryBean();
        factoryEmf.setDataSource(dataSourcePostgres());
        factoryEmf.setJpaVendorAdapter(jpaVendorAdapter());
        factoryEmf.setPackagesToScan("basePackage.model");
        factoryEmf.afterPropertiesSet();
        //noinspection ConstantConditions
        return factoryEmf.getObject();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSourcePostgres());
        Properties properties = new Properties();
        properties.setProperty("show_sql", "false");
        properties.setProperty("hbm2ddl.auto","create-drop");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.PostgresPlusDialect");
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public DataSource dataSourceH2(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/Database_H2/Spitter");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");
        return dataSource;
    }

    @Bean
    public DataSource dataSourcePostgres(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://194.87.144.153:5432/SPITTER");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        return dataSource;
    }

    @Bean
    public TransactionTemplate transactionTemplate() {
        return new TransactionTemplate(jpaTransactionManager());
    }
}
