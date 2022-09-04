package basePackage.MindReaderAndThinking;

import org.springframework.stereotype.Component;

@Component("volunteer")
public class Volunteer implements Thinker {
    private String thoughts;


    public String getThoughts() {
        return thoughts;
    }

    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }
}

