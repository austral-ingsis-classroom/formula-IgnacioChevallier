package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SquareRoot implements Function {
  private final Function num1;

  public SquareRoot(Function num1) {
    this.num1 = num1;
  }

  @Override
  public double evaluate(Map<String, Double> map) {
    return Math.sqrt(num1.evaluate(map));
  }

  @Override
  public List<String> getVariables() {
    return new ArrayList<>(num1.getVariables());
  }

  @Override
  public String toString() {
    return "(" + num1.toString() + ")";
  }
}
