package basePackage;

import org.springframework.beans.factory.annotation.Value;

public class Vocalist implements Performer {
    @Value("Не по пути")
    private String song;

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Поет песню "+song);
    }


}
