import basePackage.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {


    ApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext(
                "app-context.xml");
    }

    @Test
    public void testByName() throws PerformanceException {
        Performer duke = (Performer) ctx.getBean("kenny2");
        duke.perform();


    }

    @Test
    public void useAutowiredTest4_2_1() throws PerformanceException {
        Performer duke = (Performer) ctx.getBean(Instrumentalist.class);
        duke.perform();
    }

    @Test
    public void useInjectAnnotationTest4_2_2() throws PerformanceException {
        KnifeJuggler knifeJuggler =  ctx.getBean(KnifeJuggler.class);
    }

    @Test
    public void useExpressionValue4_2_3() throws PerformanceException {
       Performer vocalist =  ctx.getBean(Vocalist.class);
        vocalist.perform();
    }

    @Test
    public void autoScan4_2_4() throws PerformanceException {
        Performer instrumentalist = (Performer) ctx.getBean("myCustomIdInstrumentalist");
        instrumentalist.perform();
    }

    @Test
    public void autoScanFilters4_2_5() throws PerformanceException {
        Performer instrumentalist = ctx.getBean(Instrumentalist.class);
        instrumentalist.perform();
    }
}
