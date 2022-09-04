package basePackage;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.ArrayList;
import java.util.List;

public class KnifeJuggler {
    private List<Knife> knives;

    @Inject
    public KnifeJuggler(Provider<Knife> knifeProvider) {
        knives = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            knives.add(knifeProvider.get());
        }
    }

}
