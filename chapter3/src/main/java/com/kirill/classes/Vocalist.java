package com.kirill.classes;

public class Vocalist implements Performer {
    private String song;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Поет песню "+song);
    }


}
