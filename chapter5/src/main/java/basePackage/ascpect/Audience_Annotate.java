package basePackage.ascpect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/*@Aspect*/
@Component
public class Audience_Annotate {

    @Pointcut("execution(* basePackage.Performer.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void takeSeats() { // Перед выступлением
        System.out.println("Зрители занимают свои места.");
    }

    @Before("performance()")
    public void turnOffCellPhones() { // Перед выступлением
        System.out.println("Зрители выключают свои телефоны");
    }

    @AfterReturning("performance()")
    public void applaud() { // После выступления
        System.out.println("Хлоп-хлоп-хлоп-хлоп");
    }

    @AfterThrowing("performance()")
    public void demandRefund() { // После неудачного выступления
        System.out.println("Фу Гавно! Верните наши деньги обратно");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            takeSeats();
            turnOffCellPhones();
            long start = System.currentTimeMillis();

            joinPoint.proceed();

            long end = System.currentTimeMillis();
            applaud();
            System.out.println("Представление заняло " + (end-start) + " миллисекунд.");
        } catch (Throwable e) {
            demandRefund();
        }


    }
}