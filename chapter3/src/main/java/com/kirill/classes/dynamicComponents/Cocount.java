package com.kirill.classes.dynamicComponents;

public class Cocount {

    private Lime lime;

    public void dirnkThemBothUp(){
        System.out.println("Вы кладете лайм в кокос...");
        System.out.println("и пьете их обоих...");
        System.out.println("Вы кладете лайм в кокос...");
        lime.drink();

    }

    public void setLime(Lime lime){
        this.lime = lime;
    }
}
