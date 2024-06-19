package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Number implements Function {
  private double value;

  public Number(Double i) {
    this.value = i;
  }

  @Override
  public double evaluate(Map<String, Double> map) {
    return value;
  }

  @Override
  public List<String> getVariables() {
    return new ArrayList<>();
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
