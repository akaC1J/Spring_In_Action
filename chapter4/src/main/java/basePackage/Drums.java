package basePackage;

import org.springframework.stereotype.Component;

@Component
public class Drums implements Instrument {
    @Override
    public void play() {
        System.out.println("БУМ-БУМ("+getName()+")");
    }

    private String getName() {
        return "Барабаны";
    }
}
