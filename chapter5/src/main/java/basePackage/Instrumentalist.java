package basePackage;

/*@Configurable("pianist")*/
/*@SkipIt*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Instrumentalist implements Performer {


    public Instrumentalist() {
    }

    /*@Autowired
    public Instrumentalist(Instrument instrument) {
        this.instrument = instrument;
    }*/

    public void perform() throws PerformanceException {
        System.out.print("Играет " + song + " : ");

        instrument.play();
        /*throw  new PerformanceException();*/
    }

    @Value("151 Rum")
    private String song;


    public void setSong(String song) { //<co id="co_injectSong"/>
        this.song = song;
    }


   /* @MyCustomQualiferAnnotation
    @Inject
    private Instrument instrument;*/

    /*@Autowired(required = false)
    @MyCustomQualiferAnnotation
    private Instrument instrument;*/


    @Qualifier("drums")
    @Autowired
    private Instrument instrument;

    public void setInstrument(Instrument instrument) { //<co id="co_injectInstrument"/>
        this.instrument = instrument;
    }
}

