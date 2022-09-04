package com.kirill.classes;

public class Drums implements Instrument{
    @Override
    public void play() {
        System.out.println("БУМ-БУМ");
    }

    @Override
    public String getName() {
        return "Барабаны";
    }
}
