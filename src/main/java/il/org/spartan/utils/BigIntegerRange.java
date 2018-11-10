package il.org.spartan.utils;

import java.math.*;
import java.util.*;

public class BigIntegerRange {
  BigInteger from;
  BigInteger to;
  BigInteger step;
  
  public BigIntegerRange() {
    this.from = null;
    this.to = null;
    this.step = BigInteger.ONE;
  }
  
  public BigIntegerRange from(BigInteger value) {
    this.from = value;
    return this;
  }
  
  public BigInteger from() {
    return this.from;
  }
  
  public BigIntegerRange to(BigInteger value) {
    this.to = value;
    return this;
  }
  
  public BigInteger to() {
    return this.to;
  }
  
  public Iterator<BigInteger> numbers() {
    return new Iterator<BigInteger>() {
      BigInteger current = from;

      @Override public boolean hasNext() {
        return to == null || current.add(step).compareTo(to) == -1;
      }

      @Override public BigInteger next() {
        BigInteger $ = current;
        current = current.add(step);
        return $;
      }

      @Override public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  
}
