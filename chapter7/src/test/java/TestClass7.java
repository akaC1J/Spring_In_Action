import basePackage.config.A;
import basePackage.config.Config;
import basePackage.dao.HibernateSpitterDao;
import basePackage.dao.SpitterDao;
import basePackage.dao.SpitterDaoImplWithTempl;
import basePackage.model.Spitter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class TestClass7 {
    ApplicationContext ctx;

    SpitterDao spitterDao;

    @Before
    public void setUp() {
        ApplicationContext parent = new AnnotationConfigApplicationContext(Config.class);
        ctx = parent;
    }

    private void setJDBCtoDao() {
        spitterDao = ctx.getBean(SpitterDaoImplWithTempl.class);

    }

    private void setHibernateDao() {
        spitterDao = ctx.getBean(HibernateSpitterDao.class);
    }

    private void setJpaDao() {
        spitterDao = (SpitterDao) ctx.getBean("jpaSpitterDao");
    }

    private void fakeException() {
        throw new RuntimeException();
    }

    @Test
    public void JdbcTransaction_7_2_1() {
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
    public void HibernateTransaction_7_2_2() {
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
    public void JpaTransaction_7_2_3() {
        setJpaDao();
        ((TransactionTemplate) ctx.getBean("transactionTemplate")).execute((TransactionCallback<Object>) status -> {
            Spitter spitter = spitterDao.getSpitterById(1);
            System.out.println(spitter);
            spitter.setPassword("C");
            spitterDao.updateSpitter(spitter);
            spitter = spitterDao.getSpitterById(1L);
            spitter.setPassword("D");
            spitterDao.updateSpitter(spitter);
            System.out.println(spitter);

            return spitter;
        });
    }

    @Test
    public void xmlTransaction_7_4_2() {
        setJpaDao();
        Spitter spitter = new Spitter();

        spitter.setFullName("Peter");
        spitter.setEmail("peter@gmail.com");
        spitter.setPassword("asp2");
        spitter.setUsername("Spidy");
        spitter.setUpdateByEmail(false);
        spitterDao.saveSpitter(spitter);
    }

    @Test
    public void annotationTransaction_7_4_3() {
        setJpaDao();
        Spitter spitter = new Spitter();

        spitter.setFullName("Peter");
        spitter.setEmail("peter@gmail.com");
        spitter.setPassword("asp2");
        spitter.setUsername("Spidy");
        spitter.setUpdateByEmail(false);
        spitterDao.saveSpitter(spitter);
    }

    @Test
    public void someTest() {
        A a = ctx.getBean(A.class);
        System.out.println(a);
    }

}

