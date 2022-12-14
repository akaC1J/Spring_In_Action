package com.kirill.classes;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable("pianist")
public class Instrumentalist implements Performer {
    public Instrumentalist() {
    }

    public void perform() throws PerformanceException {
        System.out.print("Играет " + song + " : ");
        instrument.play();
    }

    private String song;

    public void setSong(String song) { //<co id="co_injectSong"/>
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public String screamSong() {
        return song;
    }

    private Instrument instrument;

    public void setInstrument(Instrument instrument) { //<co id="co_injectInstrument"/>
        this.instrument = instrument;
    }
}
