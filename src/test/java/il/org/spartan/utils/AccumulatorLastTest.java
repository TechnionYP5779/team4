package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Accumulator.*;

@SuppressWarnings("static-method") public class AccumulatorLastTest {
  @Test public void booleanAdds() {
    final @NotNull Last c = new Last();
    azzert.that(as.bit(false), is(0));
    azzert.that(c.value(), is(0));
    
    c.add(true);
    azzert.that(c.value(), is(1));
    azzert.that(as.bit(false), is(0));
    
    c.add(false);
    azzert.that(c.value(), is(0));
    
    c.add(false);
    azzert.that(c.value(), is(0));
    
    c.add(true);
    azzert.that(c.value(), is(1));
    
    c.add(true);
    azzert.that(c.value(), is(1));
  }

  @Test public void emptyAdds() {
    final @NotNull Last c = new Last();
    for (int ¢ = 0; ¢ < 19; ++¢)
      c.add(¢);
    c.add(11);
    azzert.that(c.value(), is(11));
  }

  @Test public void testTransform() {
    azzert.that(new Last("last").transform(1), is(1));
  }
}