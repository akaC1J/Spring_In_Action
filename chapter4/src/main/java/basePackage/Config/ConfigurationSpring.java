package basePackage.Config;

import basePackage.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSpring {

    @Bean
    public Performer juggler(){
        return new Juggler();
    }

    @Bean
    public Performer juggler15(){
        return new Juggler(15);
    }
    @Bean
    public Instrumentalist instrumentalistJavaConfig() {
        Instrumentalist instrumentalist = new Instrumentalist();
        instrumentalist.setSong("Jingle Bells");
        return instrumentalist;
    }

    @Bean
    public Poem poem(){
        return new Sonnet29();
    }

    @Bean
    public Performer poeticJuggler(){
        return new PoeticJuggler(poem());
    }
}
