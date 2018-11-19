package il.org.spartan.etc;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.English.*;
import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class EnglishTest {
  @Test public void get1() {
    azzert.that(Inflection.stem("shake").get(), is("shake"));
  }

  @Test public void get2() {
    azzert.that(Inflection.stem("shake").getEd(), is("shakeed"));
  }

  @Test public void get3() {
    azzert.that(Inflection.stem("shake").getIng(), is("shakeing"));
  }

  @Test public void get11() {
    azzert.that(Inflection.stem("sleep").get(), is("sleep"));
  }

  @Test public void get22() {
    azzert.that(Inflection.stem("sleep").getEd(), is("sleeped"));
  }

  @Test public void get33() {
    azzert.that(Inflection.stem("sleep").getIng(), is("sleeping"));
  }

  @Test public void name() {
    azzert.that(English.indefinite("hi"), is("an hi"));
  }

  @Test public void nameObj() {
    azzert.that(English.indefinite("1"), is("a some character"));
  }

  @Test public void list1() {
    azzert.that(English.list(new ArrayList<>()), is("nothing"));
  }

  // @Test public void list2() {
  // azzert.that(English.list(null), is("nothing"));
  // }
  @Test public void list3() {
    final List<String> a = new ArrayList<>();
    a.add("hi");
    azzert.that(English.list(a), is("hi"));
  }

  @Test public void list4() {
    final List<String> a = new ArrayList<>();
    a.add("hi");
    a.add("bi");
    azzert.that(English.list(a), is("hi and bi"));
  }

  @Test public void lower() {
    azzert.that(English.lowerFirstLetter("hii"), is("hii"));
  }

  @Test public void lower2() {
    azzert.that(English.lowerFirstLetter("Hi"), is("hi"));
  }

  @Test public void classs() {
    azzert.that(English.name(String.class), is("String"));
  }

  @Test public void classs2() {
    azzert.that(English.name(Integer.class), is("Integer"));
  }

  @Test public void classss() {
    azzert.that(English.name(Inflection.class), is("Inflection.English"));
  }

  @Test public void plurales() {
    azzert.that(English.plurales("hi", 1), is("one hi"));
  }

  @Test public void plurales2() {
    azzert.that(English.plurales("hi", 2), is("2 hies"));
  }

  @Test public void plurales11() {
    azzert.that(English.plurales("banana", 1), is("one banana"));
  }

  @Test public void plurales22() {
    azzert.that(English.plurales("class", 2), is("2 classes"));
  }

  @Test public void plurales3() {
    azzert.that(English.plurales("hi", new Int()), is("0 hies"));
  }

  @Test public void plurales35() {
    azzert.that(English.plurales("hi", new Int(1)), is("one hi"));
  }

  @Test public void plurales353() {
    azzert.that(English.plurales("dance", new Int(1)), is("one dance"));
  }

  @Test public void plurales4() {
    azzert.that(English.plurales("hi", (Int) null), is("??? hies"));
  }

  @Test public void plurales5() {
    azzert.that(English.plurales("hi", (Integer) null), is("??? hies"));
  }

  @Test public void plurales6() {
    azzert.that(English.plurales("hi", Integer.valueOf(4)), is("4 hies"));
  }

  @Test public void plurales36() {
    azzert.that(English.plurales("brush", Integer.valueOf(6)), is("6 brushes"));
  }

  @Test public void plurales65() {
    azzert.that(English.plurales("hi", Integer.valueOf(1)), is("one hi"));
  }

  @Test public void plurals() {
    azzert.that(English.plurals("hi", 1), is("one hi"));
  }

  @Test public void plurals2() {
    azzert.that(English.plurals("hi", 2), is("2 his"));
  }

  @Test public void plurals3() {
    azzert.that(English.plurals("hi", new Int()), is("0 his"));
  }

  @Test public void plurals35() {
    azzert.that(English.plurals("hi", new Int(1)), is("one hi"));
  }

  @Test public void plurals4() {
    azzert.that(English.plurals("hi", (Int) null), is("??? his"));
  }

  @Test public void plurals5() {
    azzert.that(English.plurals("hi", (Integer) null), is("??? his"));
  }

  @Test public void plurals6() {
    azzert.that(English.plurals("hi", Integer.valueOf(4)), is("4 his"));
  }

  @Test public void plurals633() {
    azzert.that(English.plurals("car", Integer.valueOf(22)), is("22 cars"));
  }

  @Test public void plurals65() {
    azzert.that(English.plurals("hi", Integer.valueOf(1)), is("one hi"));
  }

  @Test public void pronounce() {
    azzert.that(English.pronounce('A'), is("aey"));
    azzert.that(English.pronounce('b'), is("bee"));
    azzert.that(English.pronounce('c'), is("see"));
    azzert.that(English.pronounce('d'), is("dee"));
    azzert.that(English.pronounce('e'), is("eae"));
    azzert.that(English.pronounce('f'), is("eff"));
    azzert.that(English.pronounce('g'), is("gee"));
    azzert.that(English.pronounce('h'), is("eitch"));
    azzert.that(English.pronounce('i'), is("eye"));
    azzert.that(English.pronounce('j'), is("jay"));
    azzert.that(English.pronounce('k'), is("kay"));
    azzert.that(English.pronounce('l'), is("ell"));
    azzert.that(English.pronounce('m'), is("em"));
    azzert.that(English.pronounce('n'), is("en"));
    azzert.that(English.pronounce('o'), is("oh"));
    azzert.that(English.pronounce('p'), is("pee"));
    azzert.that(English.pronounce('q'), is("queue"));
    azzert.that(English.pronounce('r'), is("ar"));
    azzert.that(English.pronounce('s'), is("ess"));
    azzert.that(English.pronounce('t'), is("tee"));
    azzert.that(English.pronounce('u'), is("you"));
    azzert.that(English.pronounce('v'), is("vee"));
    azzert.that(English.pronounce('w'), is("some character"));
    azzert.that(English.pronounce('x'), is("exx"));
    azzert.that(English.pronounce('y'), is("why"));
    azzert.that(English.pronounce('z'), is("zee"));
  }

  @Test public void repeat() {
    azzert.that(English.repeat(4, 'z'), is("zzzz"));
  }

  @Test public void repeat2() {
    azzert.that(English.repeat(2, 'n'), is("nn"));
  }

  @Test public void selfName() {
    azzert.that(English.selfName(String.class), is("String"));
  }

  @Test public void time() {
    azzert.that(English.time(3234), is("0.00"));
  }

  @Test public void time2() {
    azzert.that(English.time(32300000), is("0.03"));
  }

  @Test public void trim() {
    azzert.that(English.trim("HI WHATS THAT"), is("HI WHATS THAT"));
  }

  @Test public void trim2() {
    azzert.isNull(English.trim(null));
  }

  @Test public void trimAbsolute() {
    azzert.that(English.trimAbsolute("HI WHATS THAT", 3, "hi"), is("Hhi"));
  }

  @Test public void unknownIfNull() {
    azzert.that(English.unknownIfNull("HI WHATS THAT"), is("HI WHATS THAT"));
  }

  @Test public void unknownIfNull2() {
    azzert.that(English.unknownIfNull("HI WHATS THAT", email -> email), is("HI WHATS THAT"));
  }

  @Test public void unknownIfNull3() {
    azzert.that(English.unknownIfNull(null, email -> email), is("???"));
  }
}
