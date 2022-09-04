package basePackage.aspectJ;

import org.springframework.stereotype.Component;


public aspect JudgeAspect {
    private CriticismEngine criticismEngine;

    pointcut performance() : execution(* perfom(..));

    after() returning() : performance() {
        System.out.println(criticismEngine.getCriticism());
    }
    // внедряется




    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

    public CriticismEngine getCriticismEngine() {
        return criticismEngine;
    }
}