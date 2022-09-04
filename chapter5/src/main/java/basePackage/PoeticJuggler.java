
package basePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PoeticJuggler extends Juggler {


  private final Poem poem;

  @Autowired
  public PoeticJuggler(Poem poem) {
    super();
    this.poem = poem;
  }

  public PoeticJuggler(int beanBags, Poem poem) {
    super(beanBags);
    this.poem = poem;
  }

  public void perform() throws PerformanceException {
    super.perform();
    System.out.println("Во время чтения...");
    poem.recite();
  }
}
