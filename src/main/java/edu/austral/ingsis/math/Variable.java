package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public class Variable implements Function {
  private String name = null;

  public Variable(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }

  @Override
  public double evaluate(Map<String, Double> map) {
    return map.get(name);
  }

  @Override
  public List<String> getVariables() {
    return List.of(this.toString());
  }
}
