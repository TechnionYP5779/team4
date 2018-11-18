package il.org.spartan.etc;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class cCamelCaseTest {
  @Test public void lastComponent() {
    azzert.that(cCamelCase.lastComponent(String.class), is("String"));
  }

  @Test public void lastComponent2() {
    azzert.that(cCamelCase.lastComponent("String"), is("String"));
  }

  @Test public void usefulTypeName() {
    assert cCamelCase.usefulTypeName("String");
    assert !cCamelCase.usefulTypeName("S");
    assert cCamelCase.usefulTypeName("s");
  }
}
