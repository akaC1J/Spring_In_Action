package basePackage.Contestant;

import org.springframework.stereotype.Component;

@Component
public class ContestantImpl implements Contestant{
    @Override
    public void receiveAward() {
        System.out.println("Какой-то хер получил награду");
    }
}
