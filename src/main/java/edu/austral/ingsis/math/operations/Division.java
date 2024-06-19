package edu.austral.ingsis.math.operations;

import static edu.austral.ingsis.math.Utility.getString;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Division implements Function {
  private final Function num1;
  private final Function num2;

  public Division(Function num1, Function num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  @Override
  public double evaluate(Map<String, Double> map) {
    return num1.evaluate(map) / num2.evaluate(map);
  }

  @Override
  public List<String> getVariables() {
    List<String> result = new ArrayList<>(num1.getVariables());
    result.addAll(num2.getVariables());
    return result;
  }

  @Override
  public String toString() {
    return getString(num1, num2, "/");
  }
}
