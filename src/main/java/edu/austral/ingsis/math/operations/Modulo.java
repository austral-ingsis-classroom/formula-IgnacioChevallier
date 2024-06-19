package edu.austral.ingsis.math.operations;

import static edu.austral.ingsis.math.Utility.formatNumber;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Modulo implements Function {
  private final Function num;

  public Modulo(Function num) {
    this.num = num;
  }

  @Override
  public double evaluate(Map<String, Double> map) {
    return Math.abs(num.evaluate(map));
  }

  @Override
  public List<String> getVariables() {
    return new ArrayList<>(num.getVariables());
  }

  @Override
  public String toString() {
    if (num instanceof Number) return "|" + formatNumber(num.evaluate(null)) + "|";
    return "|" + num.toString() + "|";
  }
}
