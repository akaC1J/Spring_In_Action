package basePackage;


import org.springframework.stereotype.Component;

/*@MyCustomQualiferAnnotation*/
public class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("Бринь-бринь("+getName()+")");
    }

    private String getName() {
        return "Гитара";
    }
}
