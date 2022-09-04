package basePackage.Contestant;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ContestantIntroducer {

    @DeclareParents(
            value = "basePackage.Performer+",
            defaultImpl = ContestantImpl.class
    )
    public static Contestant contestant;

}
