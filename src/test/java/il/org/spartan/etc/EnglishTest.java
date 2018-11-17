package il.org.spartan.etc;

import org.junit.*;

import fluent.ly.*;

import il.org.spartan.etc.English.*;
import il.org.spartan.utils.*;

import static fluent.ly.azzert.*;

import java.util.*;

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
  @Test public void name() {
    azzert.that(English.indefinite("hi"), is("an hi")); 
  }
  @Test public void nameObj() {
    azzert.that(English.indefinite("1"), is("a some character")); 
  }
  @Test public void list1() {
    azzert.that(English.list(new ArrayList<>()), is("nothing")); 
  }
//  @Test public void list2() {
//    azzert.that(English.list(null), is("nothing"));
//  }
  @Test public void list3() {
    List<String> a = new ArrayList<>();
    a.add("hi");
    azzert.that(English.list(a), is("hi")); 
  }
  @Test public void list4() {
    List<String> a = new ArrayList<>();
    a.add("hi");
    a.add("bi");
    azzert.that(English.list(a), is("hi and bi")); 
  }
  @Test public void lower() {
    azzert.that(English.lowerFirstLetter("hii"), is("hii")); 
  }
  @Test public void classs() {
    azzert.that(English.name(String.class), is("String")); 
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
  @Test public void plurales3() {
    azzert.that(English.plurales("hi", new Int()), is("0 hies")); 
  }
  @Test public void plurales35() {
    azzert.that(English.plurales("hi", new Int(1)), is("one hi")); 
  }
  @Test public void plurales4() {
    Int i = null;
    azzert.that(English.plurales("hi", i), is("??? hies")); 
  }
  @Test public void plurales5() {
    Integer i = null;
    azzert.that(English.plurales("hi", i), is("??? hies")); 
  }
  @Test public void plurales6() {
    azzert.that(English.plurales("hi", Integer.valueOf(4)), is("4 hies")); 
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
    Int i = null;
    azzert.that(English.plurals("hi", i), is("??? his")); 
  }
  @Test public void plurals5() {
    Integer i = null;
    azzert.that(English.plurals("hi", i), is("??? his")); 
  }
  @Test public void plurals6() {
    azzert.that(English.plurals("hi", Integer.valueOf(4)), is("4 his")); 
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
  @Test public void selfName() {
    azzert.that(English.selfName(String.class), is("String")); 
  }
  @Test public void time() {
    azzert.that(English.time(3234), is("0.00")); 
  }
  @Test public void trim() {
    azzert.that(English.trim("HI WHATS THAT"), is("HI WHATS THAT")); 
  }
  @Test public void trim2() {
    azzert.isNull(English.trim(null)); 
  }
  @Test public void trimAbsolute() {
    azzert.that(English.trimAbsolute("HI WHATS THAT", 3 , "hi"), is("Hhi")); 
  }
  @Test public void unknownIfNull() {
    azzert.that(English.unknownIfNull("HI WHATS THAT"), is("HI WHATS THAT")); 
  }
  @Test public void unknownIfNull2() {
    azzert.that(English.unknownIfNull("HI WHATS THAT", email ->  email), is("HI WHATS THAT")); 
  }
  @Test public void unknownIfNull3() {
    azzert.that(English.unknownIfNull(null, email ->  email), is("???")); 
  }
  
}