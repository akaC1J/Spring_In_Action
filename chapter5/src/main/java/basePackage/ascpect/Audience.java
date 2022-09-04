package basePackage.ascpect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Audience {
    public void takeSeats() { // Перед выступлением
        System.out.println("Зрители занимают свои места.");
    }
    public void turnOffCellPhones() { // Перед выступлением
        System.out.println("Зрители выключают свои телефоны");
    }
    public void applaud() { // После выступления
        System.out.println("Хлоп-хлоп-хлоп-хлоп");
    }
    public void demandRefund() { // После неудачного выступления
        System.out.println("Фу Гавно! Верните наши деньги обратно");
    }
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