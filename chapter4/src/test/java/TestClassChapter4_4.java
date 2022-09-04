import basePackage.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClassChapter4_4 {


    ApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext(
                "autoConfigSpring.xml");
    }

    @Test
    public void simpleDef4_4_3() throws PerformanceException {
        Performer juggler = (Performer) ctx.getBean("juggler");
        juggler.perform();
    }

    @Test
    public void simpleDefWithDependencies4_4_4() throws PerformanceException {
        Performer instrumentalist = (Performer) ctx.getBean("instrumentalistJavaConfig");
        instrumentalist.perform();
    }

    @Test
    public void simpleDefWithDependencies4_4_4b() throws PerformanceException {
        Performer poeticJuggler = (Performer) ctx.getBean("poeticJuggler");
        poeticJuggler.perform();
    }
}
