package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public interface Function {
  double evaluate(Map<String, Double> map);

  List<String> getVariables();

  String toString();
}
