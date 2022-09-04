package com.kirill.classes;

public class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("Бринь-бринь");
    }

    @Override
    public String getName() {
        return "Гитара";
    }
}
