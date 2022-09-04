import basePackage.config.Config;
import basePackage.dao.HibernateSpitterDao;
import basePackage.dao.SpitterDao;
import basePackage.dao.SpitterDaoImplWithTempl;
import basePackage.model.Spitter;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.transaction.Transactional;

public class TestClass7 {
    ApplicationContext ctx;

    SpitterDao spitterDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(Config.class);
    }

    private void setJDBCtoDao(){
        spitterDao = ctx.getBean(SpitterDaoImplWithTempl.class);

    }

    private void setHibernateDao() {
        spitterDao = ctx.getBean(HibernateSpitterDao.class);
    }

    private void fakeException(){
        throw new RuntimeException();
    }

    @Test
    public void JdbcTransaction_7_2_1(){
        DataSourceTransactionManager dataSourceTransactionManager = ctx.getBean(DataSourceTransactionManager.class);
        setHibernateDao();
        TransactionTemplate template = new TransactionTemplate(dataSourceTransactionManager);
        template.execute((TransactionCallback<Object>) status -> {
            Spitter spitter = spitterDao.getSpitterById(1);
            System.out.println(spitter);
            spitter.setPassword("firstTran");
            spitterDao.updateSpitter(spitter);
            spitter = spitterDao.getSpitterById(1L);
            spitter.setPassword("secondTran");
            spitterDao.updateSpitter(spitter);
            System.out.println(spitter);
            return spitter;
        });
    }

    @Test
    public void HibernateTransaction_7_2_2(){
        HibernateTransactionManager hibernateTransactionManager = ctx.getBean(HibernateTransactionManager.class);
        setJDBCtoDao();
        TransactionTemplate template = new TransactionTemplate(hibernateTransactionManager);
        template.execute((TransactionCallback<Object>) status -> {
            Spitter spitter = spitterDao.getSpitterById(1);
            System.out.println(spitter);
            spitter.setPassword("firstTran");
            spitterDao.updateSpitter(spitter);
            spitter = spitterDao.getSpitterById(1L);
            spitter.setPassword("secondTran");
            spitterDao.updateSpitter(spitter);
            System.out.println(spitter);
            return spitter;
        });
    }

    @Test
    public void someTest() {
        SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
        System.out.println(sessionFactory);

    }

}

