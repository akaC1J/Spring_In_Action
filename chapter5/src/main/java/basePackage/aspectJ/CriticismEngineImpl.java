package basePackage.aspectJ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CriticismEngineImpl implements CriticismEngine{


    @Value("#{new String[]{'Сделайте ,всем одолжение и сохраните свою, повседневную работу.'," +
            "'Вы можете быть наименее талантливым человеком в этом шоу.'," +
            "'Я не груб, но это было ужасно.'}}")
    private String[] criticismPool;

    public CriticismEngineImpl() {}

    @Override
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }


    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
