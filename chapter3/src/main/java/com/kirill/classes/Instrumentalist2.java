package com.kirill.classes;

public abstract class Instrumentalist2 implements Performer {
    public Instrumentalist2() {
    }

    public void perform() throws PerformanceException {
        System.out.print("Играет " + song + " : ");
       getInstrument().play();
    }

    private String song;

    public void setSong(String song) { //<co id="co_injectSong"/>
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public abstract Instrument getInstrument();

}
