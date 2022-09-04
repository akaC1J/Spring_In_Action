import basePackage.Contestant.Contestant;
import basePackage.MindReaderAndThinking.Magician;
import basePackage.MindReaderAndThinking.Thinker;
import basePackage.PerformanceException;
import basePackage.Performer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TestClass5_1 {
    ApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext(
                "app-context.xml");
    }

    @Test
    public void defAspect5_3_1() throws PerformanceException {
        Performer instrumentalist = (Performer) ctx.getBean("instrumentalist");
        instrumentalist.perform();
    }

    @Test
    public void defAspect5_3_2() throws PerformanceException {
       defAspect5_3_1();
    }

    @Test
    public void defAspect5_3_3_Par() throws PerformanceException {
        Magician magician = (Magician) ctx.getBean("magician");
        Thinker volunteer = (Thinker) ctx.getBean("volunteer");
        volunteer.thinkOfSomething("Queen of Hearts");
        assertEquals("Queen of Hearts", magician.getThoughts());
    }

    @Test
    public void defAspect5_3_4_внедрение() throws PerformanceException {
        Object instrumentalist = ctx.getBean("instrumentalist");
        ((Contestant)instrumentalist).receiveAward();
        ((Performer)instrumentalist).perform();
    }

    @Test
    public void defAspect5_4_0_аспекты_с_анотациями() throws PerformanceException {

        Performer instrumentalist = (Performer) ctx.getBean("instrumentalist");

        instrumentalist.perform();
    }

    @Test
    public void defAspect5_4_2_аспекты_с_анотациями_с_переданными_параметрами() throws PerformanceException {
        Thinker volunteer = ctx.getBean(Thinker.class);
        Magician magician = (Magician) ctx.getBean("magician");
        volunteer.thinkOfSomething("Ща бы посрать");
        assertEquals("Ща бы посрать", magician.getThoughts());
    }

    @Test
    public void defAspect5_4_2_аспекты_с_анотациями_внедрение() throws PerformanceException {
        defAspect5_3_4_внедрение();
    }

    @Test
    public void defAspect5_4_2_аспектЖи() throws PerformanceException {
        defAspect5_4_0_аспекты_с_анотациями();

    }
    @Test
    public void test () throws PerformanceException {
       List<Long> longs = new ArrayList<>();
       longs.add(30L);
       longs.add(10L);
       longs.add(15L);
       longs = longs.stream().
               sorted().collect(Collectors.toList());
       System.out.println(longs);
    }

}
