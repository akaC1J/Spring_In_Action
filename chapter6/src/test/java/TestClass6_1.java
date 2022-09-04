import basePackage.dao.HibernateSpitterDao;
import basePackage.dao.SpitterDao;
import basePackage.model.Spitter;
import basePackage.dao.SpitterDaoImplWithTempl;
import basePackage.dao.SpitterDaoImpl;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestClass6_1 {
   private ApplicationContext ctx;
   private SpitterDaoImpl spitterDaoImpl;
   private SpitterDao hibernateSpitterDao;
   private SpitterDaoImplWithTempl spitterDaoImplWithTempl;

   private SpitterDao jpaSpitterDao;



    @Before
    public void setUp() {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE);
        ctx = new ClassPathXmlApplicationContext(
                "app-context.xml");
       spitterDaoImpl = (SpitterDaoImpl) ctx.getBean("spitterDaoImpl");
       hibernateSpitterDao = (SpitterDao) ctx.getBean("hibernateSpitterDao");
       spitterDaoImplWithTempl = (SpitterDaoImplWithTempl) ctx.getBean("spitterDaoImplWithTempl");
       jpaSpitterDao = (SpitterDao) ctx.getBean("jpaSpitterDao");
    }

    @After
    public void after(){
//        hibernateSpitterDao.currentSession().flush();
//        hibernateSpitterDao.currentSession().close();
    }

    @Test
    public void test_6_3_1_Борьба_с_разбуханием_JDBC_кода() {
        Spitter spitter = new Spitter();
        spitter.setFullName("Kirill");
        spitter.setUsername("akaS1j");
        spitter.setPassword("passKirill");
        spitterDaoImpl.addSpitter(spitter);
    }

    @Test
    public void test_6_3_1_Борьба_с_разбуханием_JDBC_кода_v2() {
        Spitter spitter = new Spitter();
        spitter.setFullName("Kirill");
        spitter.setUsername("akaS1j");
        spitter.setPassword("llirik");
        spitter.setId(1L);
        spitterDaoImpl.saveSpitter(spitter);
    }

    @Test
    public void test_6_3_1_Борьба_с_разбуханием_JDBC_кода_v3() {
        Spitter spitter = spitterDaoImpl.getSpitterById(1);
        System.out.println(spitter);
    }
    @Test
    public void test_6_3_2_Работа_с_шаблонами_JDBC(){
        Spitter spitter = new Spitter();
        spitter.setFullName("Sonya");
        spitter.setUsername("Beaty");
        spitter.setPassword("pass");
        spitter.setEmail("sonya@gmail.com");
        spitterDaoImplWithTempl.addSpitter(spitter);
    }

    @Test
    public void test_6_3_2_Работа_с_шаблонами_JDBC_V1(){
        System.out.println(spitterDaoImplWithTempl.getSpitterById(2));
    }

    @Test
    public void test_6_3_2_Работа_с_шаблонами_JDBC_V2(){
        Spitter spitter = new Spitter();
        spitter.setFullName("Ilya");
        spitter.setUsername("Manka");
        spitter.setPassword("bkmz");
        spitter.setEmail("ilya99@mail.ru");
        spitter.setUpdateByEmail(true);
        spitterDaoImplWithTempl.addSpitter(spitter);
    }

    @Test
    public void test_6_4_3_Создание_классов_для_работы_с_Hibernate_независимых_от_Spring(){
        Spitter spitter = hibernateSpitterDao.getSpitterById(2);
        System.out.println(spitter);
        spitter.setPassword("somePassword");
        hibernateSpitterDao.saveSpitter(spitter);
        System.out.println(hibernateSpitterDao.getSpitterById(2));

    }

    @Test
    public void test_6_5_2_Объект_DAO_на_основе_JPA_v1(){
       Spitter spitter = jpaSpitterDao.getSpitterById(3);
        System.out.println(spitter);
    }

    @Test
    public void test_6_5_2_Объект_DAO_на_основе_JPA_v2(){
        System.out.println(jpaSpitterDao.getSpitterById(4));

    }




}
