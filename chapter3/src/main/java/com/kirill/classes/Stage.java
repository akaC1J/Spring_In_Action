package com.kirill.classes;

public class Stage {

    private Stage() {

    }

    private static class StageSingletonHolder{
        static Stage stage = new Stage();
    }

    public static Stage getInstance(){
        return StageSingletonHolder.stage;
    }

}
