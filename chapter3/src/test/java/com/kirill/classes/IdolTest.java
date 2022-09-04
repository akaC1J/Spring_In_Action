package com.kirill.classes;

import com.kirill.classes.customEditors.Contact;
import com.kirill.classes.customEditors.PhoneNumber;
import com.kirill.classes.dynamicComponents.Cocount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;


public class IdolTest {
    ApplicationContext ctx;
    @Before
    public void setUp(){
        ctx = new ClassPathXmlApplicationContext(
                "app-context.xml");
    }
    @Test
    public void test1() throws PerformanceException {
        String s = "Sddsd:{p}";
        System.out.println(s.replace(":{p}","123"));
        Ticket ticket= (Ticket) ctx.getBean("ticket");
        ticket.printNumberTicket();
        Ticket ticket2 = (Ticket) ctx.getBean("ticket");
        ticket2.printNumberTicket();
        /*performer.perform();*/
    }

    @Test
    public void test2() throws PerformanceException{
       Performer kenny = (Performer) ctx.getBean("kenny");
       kenny.perform();
    }

    @Test
    public void test3() throws PerformanceException{
        Performer performer = (Performer) ctx.getBean("poeticDuke");
        performer.perform();
    }

    @Test
    public void test4() throws PerformanceException{
        Performer performer = (Performer) ctx.getBean("homer");
        performer.perform();
    }
    @Test
    public void testSpEL() throws PerformanceException{
        TestSpEL spEL = (TestSpEL) ctx.getBean("testSpEL");
        System.out.println(spEL.getAsString());
    }

    @Test
    public void testMagican() throws PerformanceException{
        Performer harry = (Performer) ctx.getBean("harry");
        harry.perform();
    }

    @Test
    public void testPianoAbstract() throws PerformanceException{
        Instrumentalist pianist= new Instrumentalist();
        pianist.perform();
    }

    @Test
    public void testCustomEditor(){
        ApplicationContext propertyEditorContext = new ClassPathXmlApplicationContext("propertyEditor-context.xml");
        Contact contact = (Contact) propertyEditorContext.getBean("contact");
        System.out.println(contact.getPhoneNumber());
    }

    @Test
    public void testBeanProcessor() throws PerformanceException{
        ApplicationContext postBeanContext = new ClassPathXmlApplicationContext("postBean-context.xml");
        /*Performer vocalist = (Performer) postBeanContext.getBean("vocalist");
        vocalist.perform();
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();*/
        Locale locale = Locale.getDefault();
        String text = postBeanContext.getMessage("computer",new Object[0],locale);
        System.out.println(text);
    }

    @Test
    public void testDynamicComponent() throws PerformanceException{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dynamicComponent-context.xml");
        Cocount cocount = (Cocount) applicationContext.getBean("cocount");
        cocount.dirnkThemBothUp();
    }

    @Test
    public void test5(){
        Instrument instrument = ctx.getBean(Guitar.class);
        instrument.play();
    }

    @After
    public void after(){
        ((ClassPathXmlApplicationContext)ctx).close();
    }


}