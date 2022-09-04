package com.kirill.classes;

public class Piano  implements  Instrument{
    @Override
    public void play() {
        System.out.println("Плюм плюм плюм");
    }

    @Override
    public String getName() {
        return "Пианино";
    }
}
