package com.kirill.classes;

import java.util.Random;

public class Ticket {

    private final String number;

    public Ticket() {
        Random rnd = new Random();
        char sym1 =  (char) ('A' + rnd.nextInt(26));
        char sym2 =  (char) ('A' + rnd.nextInt(26));
        char sym3 =  (char) ('A' + rnd.nextInt(26));
        char sym4 = (char) ('0'+rnd.nextInt(9));
        char sym5 = (char) ('0'+rnd.nextInt(9));
        number = sym1+""+sym2+""+sym4+""+sym5+""+sym2+"";
    }

    public void printNumberTicket(){
        System.out.println(number);
    }
}
