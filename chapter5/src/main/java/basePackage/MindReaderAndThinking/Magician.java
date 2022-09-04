package basePackage.MindReaderAndThinking;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Magician implements MindReader{
    private String thoughts;

    @Pointcut("execution(* basePackage.MindReaderAndThinking.Thinker.thinkOfSomething(String)) && args(thoughts) ")
    public void thinking(String thoughts){}

    @Before(value = "thinking(thoughts)", argNames = "thoughts")
    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Перехват мыслей добровольца");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
